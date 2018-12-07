package com.itsight.cuy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.itsight.cuy.constants.ViewConstant;
import com.itsight.cuy.domain.Parameter;
import com.itsight.cuy.domain.dto.CustomError;
import com.itsight.cuy.domain.dto.ResLoginCuy;
import com.itsight.cuy.service.ParameterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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
            Gson json = new Gson();
            ResLoginCuy res = json.fromJson(resCuyLogin, ResLoginCuy.class);
            Parameter parameterTokenLogin =  parameterService.findOne(11);
            parameterTokenLogin.setValue(res.getOauthToken());
            parameterService.save(parameterTokenLogin);
            Parameter parameterCuyLoginId =  parameterService.findOne(12);
            parameterCuyLoginId.setValue(res.getData().getId());
            parameterService.save(parameterCuyLoginId);
            LOGGER.info(resCuyLogin);
        }catch (HttpStatusCodeException e) {

            if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {

                String responseString = e.getResponseBodyAsString();

                ObjectMapper mapper = new ObjectMapper();

                CustomError result = mapper.readValue(responseString,
                        CustomError.class);

                if(result.toString().contains("AUTHENTICATION_ERROR") && result.toString().contains("Todo bien por ahi")){
                    headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_JSON);

                    Parameter parameterTokenLogin =  parameterService.findOne(11);
                    headers.set("Authorization", "Cuy-oauthtoken "+ parameterTokenLogin.getValue());

                    httpEntity = new HttpEntity<>(headers);
                    restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
                    Parameter parameterCuyLoginId =  parameterService.findOne(12);
                    System.out.println(restTemplate.postForObject("http://apistaging.cuy.pe/api/v1/user/logout/"+parameterCuyLoginId.getValue(), httpEntity, String.class));
                    return "redirect:/visa/recarga";
                }
                System.out.println(result.toString());
                return "redirect:/visa/auth?error=error";
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

    @GetMapping("/recarga")
    public String vistaParaRecargasAfterLogin(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Parameter parameterTokenLogin =  parameterService.findOne(11);
        headers.add("Authorization", "Cuy-oauthtoken "+ parameterTokenLogin.getValue());
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        try {
            System.out.println(restTemplate.exchange("http://apistaging.cuy.pe/api/v1/suscription/balance/3?mobileNumber=51912000001", HttpMethod.GET, entity, String.class));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return "login_recarga";
        }
        return ViewConstant.PRE_FORM_VISA;
    }
}
