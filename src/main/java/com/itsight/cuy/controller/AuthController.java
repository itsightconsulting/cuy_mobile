package com.itsight.cuy.controller;

import com.itsight.cuy.constants.ViewConstant;
import com.itsight.cuy.repository.OauthApprovalsRepository;
import com.itsight.cuy.repository.OauthClientDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.approval.Approval;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.security.oauth2.provider.ClientDetailsService;

import java.util.*;

import static java.util.Arrays.asList;


@Controller
public class AuthController {

    @Autowired
    private ApprovalStore approvalStore;

    @Autowired
    private OauthClientDetailsRepository oauthClientDetailsRepository;

    @Autowired
    private OauthApprovalsRepository oauthApprovalsRepository;

    private ClientDetailsService clientDetailsService;

    @RequestMapping("/")
    public ModelAndView root(Map<String,Object> model){
        model.put("approvals", oauthApprovalsRepository.findAll());
        model.put("clientDetails",oauthClientDetailsRepository.findAll());
        return new ModelAndView ("index",model);
    }

    @Autowired
    private TokenStore tokenStore;

    @RequestMapping(value="/approval/revoke",method= RequestMethod.POST)
    public String revokApproval(@ModelAttribute Approval approval){

        approvalStore.revokeApprovals(asList(approval));
        tokenStore.findTokensByClientIdAndUserName(approval.getClientId(),approval.getUserId())
                .forEach(tokenStore::removeAccessToken) ;
        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String loginForm(@RequestParam(value = "error", required = false) String error,
                            Model model
    ) {
        if (error != null) {
            if (error.equals("session-expired")) {
                model.addAttribute("expired", "expired");
            } else {
                model.addAttribute("error", "error");
            }
        }
        return ViewConstant.LOGIN;
    }

    //	@PreAuthorize("hasAnyRole({'ADMIN','USER'}) or hasAuthority('READ_PRIVILEGE')")
    @GetMapping(value = {"/bienvenido"})
    public String welcome() {
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for (GrantedAuthority authority: authorities){
            if(authority.getAuthority().equals("ROLE_TRAINER") || authority.getAuthority().equals("ROLE_ADMIN"))
                return ViewConstant.PRINCIPAL;
            if(authority.getAuthority().equals("ROLE_RUNNER") || authority.getAuthority().equals("ROLE_STORE"))
                return ViewConstant.PRINCIPAL;
        }
        return ViewConstant.PRINCIPAL;
    }

    @GetMapping(value = "/accesoDenegado", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String permisosInsuficientes() {
        return ViewConstant.ERROR403;
    }

    @GetMapping(value = "/session-expirada", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String expiredSession() {
        return "{\"mensaje\": \"Su sessión ha expirado, por favor dirigirse a la pagina /login\"}";
    }

    @GetMapping(value = "/session-multiple")
    public String expiredBySessionMultiple(Model model) {
        return "lock";
    }


}
