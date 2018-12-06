package com.itsight.cuy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itsight.cuy.constants.ViewConstant;
import com.itsight.cuy.domain.dto.CustomError;
import com.itsight.cuy.service.ParameterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletContext;
import java.io.IOException;

@Controller
@RequestMapping("/visa")
public class VisaController {

    private static final Logger LOGGER = LogManager.getLogger(VisaController.class);

    private ParameterService parameterService;

    @Autowired
    public VisaController(ParameterService parameterService){
        this.parameterService = parameterService;
    }

    @Autowired
    private ServletContext context;

    @GetMapping("/auth")
    public String vistaInicioSessionClienteCuy(@RequestParam(value = "error", required = false) String error,
                                          Model model){
        if (error != null) {
            if (error.equals("session-expired")) {
                model.addAttribute("expired", "expired");
            } else {
                model.addAttribute("error", "error");
            }
        }
        return "login_recarga";
    }

    @PostMapping(value = "/loginRecarga")
    public String loginForm(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password
    ) throws IOException {
        String cuyInitToken = context.getAttribute("CUY_API_INIT_TOKEN").toString();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Cuy-oauthtoken "+ cuyInitToken);
        String jsonBody = "{\"email\": \""+email+"\", \"password\": \""+password+"\"}";
        HttpEntity<String> httpEntity = new HttpEntity<>(jsonBody, headers);
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        try {
            String resCuyLogin = restTemplate.postForObject("http://apistaging.cuy.pe/api/v1/user/login", httpEntity, String.class);
            System.out.println(resCuyLogin);
            LOGGER.info(resCuyLogin);
        }catch (HttpStatusCodeException e) {

            if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {

                String responseString = e.getResponseBodyAsString();

                ObjectMapper mapper = new ObjectMapper();

                CustomError result = mapper.readValue(responseString,
                        CustomError.class);
                System.out.println(result.toString());
            }
        }
        catch (Exception ex){
            System.out.println(ex.getCause());
            ex.printStackTrace();
            return "redirect:/visa/auth?error=error";
        }
        return ViewConstant.PRE_FORM_VISA;
    }

    @GetMapping("/pago")
    public @ResponseBody String vistaInicioSessionClienteCuy(@RequestParam(value = "amount") String amount){
        context.setAttribute("RECHARGE_AMOUNT", amount);
        return "1";
    }
}
