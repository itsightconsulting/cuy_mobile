package com.itsight.cuy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.itsight.cuy.domain.dto.CustomError;
import com.itsight.cuy.domain.dto.InitVisaDto;
import com.itsight.cuy.domain.dto.ResBaseRechargeCuy;
import com.itsight.cuy.domain.dto.ResponseVisaDto;
import com.itsight.cuy.service.ParameterService;
import com.itsight.cuy.util.Parseador;
import com.itsight.cuy.util.Utilitarios;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.text.ParseException;

@Controller
@RequestMapping("/p")
public class VisaDemoController {

    private static volatile SecureRandom numberGenerator = null;
    private static final long MSB = 0x8000000000000000L;
    private static int id=83;

    @Autowired
    private ServletContext context;

    @Autowired
    private ParameterService parameterService;

    @GetMapping("/terminos")
    public ModelAndView terminosCondiciones(){
        return new ModelAndView("visa/terminos");
    }

    @GetMapping(value = "/pago")
    public ModelAndView iniciarSessionApiVisa(Model model, HttpSession session) throws IOException {
        SecureRandom ng = numberGenerator;
        if (ng == null) {
            numberGenerator = ng = new SecureRandom();
        }

        ResponseEntity<String> response;

        double amount = Double.parseDouble(context.getAttribute("RECHARGE_AMOUNT").toString());
        String authVisa = context.getAttribute("VISA_API_KEY_ID") + ":" + context.getAttribute("VISA_API_KEY_PASSWORD");
        byte[] encodedAuth = Base64.encodeBase64(authVisa.getBytes(Charset.forName("US-ASCII")));

        String authHeader = "Basic " + new String( encodedAuth );

        //ACCESS TO API SESSION
        String prekeyForm = Long.toHexString(MSB | ng.nextLong()) + Long.toHexString(MSB | ng.nextLong());
        String sessionToken = Utilitarios.parseFormalUUID(prekeyForm);

        //1. INVOCANDO LA API DE SEGURIDAD
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.set("Authorization", authHeader);

        String VISA_API_INIT = context.getAttribute("VISA_API_INIT_SEC").toString();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        response = restTemplate.exchange(VISA_API_INIT, HttpMethod.GET, entity, String.class);
        String securityVisaCode = response.getBody();
        //CONFIGURATING THE HEADER
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", securityVisaCode);

        //CREATING THE REST TEMPLATE
        restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        ResponseEntity<InitVisaDto> secResponseEntity = null;
        try {
            String VISA_API_INIT_SESSION = context.getAttribute("VISA_API_INIT_SESSION").toString() + context.getAttribute("VISA_MERCHANT_ID").toString();
            //String jsonParam = "{\"amount\":\""+ Parseador.fromDoubleToBigDecimal(amount, 2)+"\"}";//2:decimals
            String jsonParam =
            "{\"amount\": \""+amount+"\",\"antifraud\":{\"clientIp\":\""+ InetAddress.getLocalHost().getHostAddress()+"\",\"merchantDefineData\":{\"MDD1\":\"1\",\"MDD2\":\"2\",\"MDD3\":\"3\" } },\"channel\":\"web\",\"recurrenceMaxAmount\":\""+amount+"\"}";
            System.out.println(jsonParam);
            entity = new HttpEntity<>(jsonParam, headers);
            secResponseEntity = restTemplate.exchange(VISA_API_INIT_SESSION, HttpMethod.POST, entity, InitVisaDto.class);
            System.out.println("STATUS REST: "+secResponseEntity.getStatusCodeValue());
        }catch (HttpStatusCodeException e) {
            System.out.println(e.getResponseBodyAsString());
            return new ModelAndView("visa/pago");
        }
        catch (Exception e) {
            System.out.println("** Exception: "+ e.getMessage());
            e.printStackTrace();
            return new ModelAndView("visa/pago");
        }

        InitVisaDto responseBatchVisa = secResponseEntity.getBody();
        //INYECTING VARIABLES
        model.addAttribute("ACTION", context.getAttribute("DOMAIN_NAME")+"p/pago/confirmacion");
        model.addAttribute("VISA_API_MERCHANT_ID", context.getAttribute("VISA_MERCHANT_ID").toString());
        model.addAttribute("LOGO_IMAGE", context.getAttribute("DOMAIN_NAME")+"img/cuy_visa.png");
        model.addAttribute("SESSION_TOKEN", responseBatchVisa.getSessionKey());
        model.addAttribute("AMOUNT", BigDecimal.valueOf(amount).setScale(2));
        model.addAttribute("TRANSACTION_ID", ++id);//Por lo general acá va el ID de mi tabla
        model.addAttribute("SESSION_KEY", responseBatchVisa.getSessionKey());

        session.setAttribute("sessionToken", responseBatchVisa.getSessionKey());
        session.setAttribute("sessionFormatoId", id);//
        session.setAttribute("sessionMontoTUPA", amount);
        session.setAttribute("SESSION_TOKEN_SEC", securityVisaCode);
        return new ModelAndView("visa/pago");
    }

    @PostMapping("/pago/confirmacion")
    public ModelAndView cierrePagoVisa(@RequestParam(name="transactionToken") String transactionToken, HttpSession session, RedirectAttributes redirect)
    {
        //4919148107859067 | accept@cybersource.com
        System.out.println("TRANSACTION TOKEN: >>>> "+transactionToken);
        try {
            //Get session values
            //String sessionToken = (String) session.getAttribute("sessionToken");
            String securityVisaCode = (String) session.getAttribute("SESSION_TOKEN_SEC");
            double amount = Double.parseDouble(context.getAttribute("RECHARGE_AMOUNT").toString());

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", securityVisaCode);

            //ACCESS TO API SESSION |

            RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
            String jsonParam = "{\"antifraud\":null,\"captureType\":\"manual\",\"cardHolder\":{\"documentNumber\":\"12345678\",\"documentType\":\"0\"},\"channel\":\"web\",\"countable\":true,\"order\":{\"amount\":\""+amount+"\",\"currency\":\"PEN\",\"productId\":\""+id+"\",\"purchaseNumber\":\""+id+"\",\"tokenId\":\""+transactionToken+"\"},\"recurrence\":{\"amount\":\""+amount+"\",\"beneficiaryId\":\"602545705\",\"frequency\":\"MONTHLY\",\"maxAmount\":\""+amount+"\",\"type\":\"FIXED\"},\"terminalId\":\"1\",\"terminalUnattended\":false}}";
          /*  String jsonParam = "{\"transactionToken\":\""+transactionToken+"\","
                    + "\"sessionToken\":\""+sessionToken+"\"}";*/
            HttpEntity<String> entity = new HttpEntity<>(jsonParam, headers);
            //ALL RESPONSE
            String responseApi = restTemplate.postForObject(context.getAttribute("VISA_API_TRANSACT").toString() + context.getAttribute("VISA_MERCHANT_ID").toString(), entity, String.class);
            System.out.println(("RESPONSE VISA API: "+ responseApi));
            Gson json = new Gson();
            ResponseVisaDto res = json.fromJson(responseApi, ResponseVisaDto.class);

            //Actualizando saldos
            headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Cuy-oauthtoken sys_sk_test_LeETLGDW9rgB78auKHVMWQOVXFViaxIffPUXgLScAToWb");

            //ACCESS TO API SESSION

            restTemplate = new RestTemplate();
            String jsonParam2 = "{\"mobileNumber\":\"51912000001\",\"amount\":"+amount*100+"}";
          /*  String jsonParam = "{\"transactionToken\":\""+transactionToken+"\","
                    + "\"sessionToken\":\""+sessionToken+"\"}";*/
            HttpEntity<String> entity2 = new HttpEntity<>(jsonParam2, headers);
            //ALL RESPONSE
            String responseApi2 = "";
            try {
                responseApi2 = restTemplate.postForObject("http://apistaging.cuy.pe/api/v1/transaction/recharge-credit", entity2, String.class);
                json = new Gson();
                ResBaseRechargeCuy resBaseRechargeCuy = json.fromJson(responseApi2, ResBaseRechargeCuy.class);
                redirect.addFlashAttribute("balance", resBaseRechargeCuy);
                headers.set("Authorization", "Cuy-oauthtoken "+ parameterService.findOne(11).getValue());
                entity2 = new HttpEntity<>("{\"mobileNumber\":\"51912000001\"}", headers);
                redirect.addFlashAttribute("tranxs", restTemplate.exchange("http://apistaging.cuy.pe/api/v1/transaction/list-suscription/3?mobileNumber=51912000001&limit=20", HttpMethod.GET, entity2, String.class));

            }catch (Exception ex){
                ex.printStackTrace();
                redirect.addFlashAttribute("balance", new ResBaseRechargeCuy());
            }

            redirect.addFlashAttribute("consolidado", res);
            System.out.println(responseApi2);
            return new ModelAndView("redirect:/p/visa/recarga/consolidado");
        }catch (HttpStatusCodeException e) {
            System.out.println(e.getResponseBodyAsString());
            return new ModelAndView("redirect:/p/visa/fallo");

        }
        catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("redirect:/p/visa/fallo");
        }
    }

    @GetMapping("/visa/recarga/consolidado")
    public String vistaConsolidadoAfterRecargaExitosa(){
        return "visa/consolidado";
    }

    @GetMapping("/visa/fallo")
    public @ResponseBody String vistaVisaOperacionDenegada(){
        return "La operación ha sido denegada...";
    }
}
