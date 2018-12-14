package com.itsight.cuy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.itsight.cuy.constants.ViewConstant;
import com.itsight.cuy.domain.Parameter;
import com.itsight.cuy.domain.dto.*;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/kasnet")
public class KasNetController {

    private static final Logger LOGGER = LogManager.getLogger(VisaController.class);

    private ParameterService parameterService;

    @Autowired
    public KasNetController(ParameterService parameterService){
        this.parameterService = parameterService;
    }

    @Autowired
    private ServletContext context;


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
                    loginForm(email, password);
                    return "redirect:/kasnet/recarga";
                }
                System.out.println(result.toString());
                return "redirect:/kasnet/auth?error=error";
            }
        }
        catch (Exception ex){
            System.out.println(ex.getCause());
            ex.printStackTrace();
            return "redirect:/kasnet/auth?error=error";
        }
        return ViewConstant.PRE_FORM_KASNET;
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
            return ViewConstant.PRE_FORM_KASNET;
        }
        return ViewConstant.PRE_FORM_KASNET;
    }


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
        return "login_recarga_kasnet";
    }

    @GetMapping("/getpago")
    public @ResponseBody
    ResBaseRechargeCuy vistaObtenerAmount(@RequestParam(value = "nrosumin") String nrosumin,
                                        @RequestParam(value = "tiposerv") String tiposerv){

        String oauthToken = "sys_sk_test_kLeETLGDW9rgB78auKHVMWQOVXFViaxIffPUXgLScAToWb";
        ResBaseRechargeCuy resBaseRechargeCuy = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Cuy-oauthtoken "+oauthToken);

        //ACCESS TO API SESSION
        Gson json = new Gson();

        String jsonParam2 = "{\"NROSUMIN\":"+ nrosumin +",\"TPSERV\":"+tiposerv+"}";

        HttpEntity<String> entity2 = new HttpEntity<>(jsonParam2, headers);
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String responseApi2 = "";

        try {
            String URI = "http://apistaging.cuy.pe/api/v1/kasnet/balance?NROSUMIN="+nrosumin+"&TPSERV="+tiposerv;
            responseApi2 = restTemplate.exchange(URI, HttpMethod.GET, entity2, String.class).getBody();

            json = new Gson();
            resBaseRechargeCuy = json.fromJson(responseApi2, ResBaseRechargeCuy.class);

            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmm");
            String datestr = sf.format(new Date());

            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();

            double amount = Double.parseDouble(resBaseRechargeCuy.getData().getAmount())/100;

            resBaseRechargeCuy.getData().setAmount(amount+"");
            resBaseRechargeCuy.getData().setTransactionDate(datestr);
            resBaseRechargeCuy.getData().setGenerateCode(randomUUIDString);
            resBaseRechargeCuy.getData().setIdentifier(nrosumin);

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return resBaseRechargeCuy;
    }



    @GetMapping("/pre_pago")
    public String prePago() {
        return ViewConstant.PRE_FORM_KASNET;
    }

    @GetMapping("/crear_pago")
    public String afterVisaCrearPago() {
        return ViewConstant.CREATE_PAY_FORM_KASNET;
    }


    @GetMapping("/extorno_pago")
    public @ResponseBody ResBaseRechargeCuy doExtornoPago(@RequestParam(value = "nrosumin") String nrosumin,
                                             @RequestParam(value = "monto") String monto,
                                             @RequestParam(value = "fecha") String fecha,
                                             @RequestParam(value = "codigo") String codigo,
                                             @RequestParam(value = "nroterm") String nroterm)  {


        String oauthToken = "sys_sk_test_kLeETLGDW9rgB78auKHVMWQOVXFViaxIffPUXgLScAToWb";
        ResBaseRechargeCuy resBaseRechargeCuy = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Cuy-oauthtoken "+oauthToken);

        //ACCESS TO API SESSION
        Gson json = new Gson();

        String jsonParam2 = "{\"NROSUMIN\":"+ nrosumin +",\"MONTO\":"+monto+",\"FECHAPAGO\":"+fecha+",\"CODGKN\":"+codigo+",\"NROTER\":"+nroterm+"}";

        HttpEntity<String> entity2 = new HttpEntity<>(jsonParam2, headers);
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String responseApi2 = "";
        String result = "";

        try {
            String URI = "http://apistaging.cuy.pe/api/v1/kasnet/payment/cancel";

            responseApi2 = restTemplate.postForObject(URI, entity2, String.class);
            json = new Gson();
            resBaseRechargeCuy = json.fromJson(responseApi2, ResBaseRechargeCuy.class);

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return resBaseRechargeCuy;
    }

    @GetMapping("/pago")
    public @ResponseBody String vistaInicioSessionClienteCuy(@RequestParam(value = "nrosumin") String nrosumin,
                                                             @RequestParam(value = "amountstr") String amountstr){
        context.setAttribute("NUMBER_AMOUNT_K", nrosumin);
        context.setAttribute("RECHARGE_AMOUNT_K", amountstr);
        return "1";
    }


    @GetMapping("/realizar_pago")
    public @ResponseBody String doCreatePago(@RequestParam(value = "nrosumin") String nrosumin,
                                     @RequestParam(value = "monto") String monto,
                                     @RequestParam(value = "fecha") String fecha,
                                     @RequestParam(value = "codigo") String codigo,
                                     @RequestParam(value = "nroterm") String nroterm) {

        String oauthToken = "sys_sk_test_kLeETLGDW9rgB78auKHVMWQOVXFViaxIffPUXgLScAToWb";
        ResBaseRechargeCuy resBaseRechargeCuy = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Cuy-oauthtoken "+oauthToken);

        //ACCESS TO API SESSION
        Gson json = new Gson();

        String jsonParam2 = "{\"NROSUMIN\":"+ nrosumin +",\"MONTO\":"+monto+",\"FECHAPAGO\":"+fecha+",\"CODGKN\":"+codigo+",\"NROTER\":"+nroterm+"}";

        HttpEntity<String> entity2 = new HttpEntity<>(jsonParam2, headers);
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String responseApi2 = "";
        String result = "";

        try {
            String URI = "http://apistaging.cuy.pe/api/v1/kasnet/payment/create";

            responseApi2 = restTemplate.postForObject(URI, entity2, String.class);
            json = new Gson();
            resBaseRechargeCuy = json.fromJson(responseApi2, ResBaseRechargeCuy.class);
            result = resBaseRechargeCuy.getData().getBalance();

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }


        return result;
    }


    @GetMapping("/listar")
    public @ResponseBody
    ResponseEntity<String> listarTransacciones(@RequestParam(value = "nrosumin") String nrosumin ){

        //Parameter parameterToken =  parameterService.findOne(13);
        Parameter parameterUserId =  parameterService.findOne(12);
        String result = "";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String oauthToken = "user_sk_test_3ucmBPdUjWtukMefia1lJOKwOXxuUUUm3Q6g1lxAij4SeKP";
        headers.set("Authorization", "Cuy-oauthtoken "+oauthToken);

        String jsonParam2 = "{\"mobileNumber\":"+ nrosumin +",\"limit\":"+20+"}";
        HttpEntity<String> entity = new HttpEntity<>(jsonParam2,headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> tmp = null;
        Gson json = new Gson();

        try {
            String id = parameterUserId.getValue();

            String URI = "http://apistaging.cuy.pe/api/v1/transaction/list-subscription/"+id+"?mobileNumber="+nrosumin+"&limit=20";
            tmp = restTemplate.exchange(URI, HttpMethod.GET, entity, String.class);


        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }

        return tmp;
    }



}
