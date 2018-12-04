package com.itsight.cuy.controller;

import com.google.gson.Gson;
import com.itsight.cuy.domain.dto.InitVisaDto;
import com.itsight.cuy.domain.dto.ResponseVisaDto;
import com.itsight.cuy.util.Parseador;
import com.itsight.cuy.util.Utilitarios;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    private static int id=0;

    @Autowired
    private ServletContext context;

    @GetMapping("/terminos")
    public ModelAndView terminosCondiciones(){
        return new ModelAndView("visa/terminos");
    }

    @GetMapping(value = "/pago")
    public ModelAndView iniciarSessionApiVisa(Model model, HttpSession session) {
        SecureRandom ng = numberGenerator;
        if (ng == null) {
            numberGenerator = ng = new SecureRandom();
        }

        ResponseEntity<String> response;

        double amount = 1;
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
        System.out.println(securityVisaCode);
        //CONFIGURATING THE HEADER
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", securityVisaCode);

        //CREATING THE REST TEMPLATE
        restTemplate = new RestTemplate();
        ResponseEntity<InitVisaDto> secResponseEntity;
        try {
            String VISA_API_INIT_SESSION = context.getAttribute("VISA_API_INIT_SESSION").toString() + context.getAttribute("VISA_MERCHANT_ID").toString();
            //String jsonParam = "{\"amount\":\""+ Parseador.fromDoubleToBigDecimal(amount, 2)+"\"}";//2:decimals
            String jsonParam =
            "{\"amount\": \"1.00\",\"antifraud\":{\"clientIp\":\""+ InetAddress.getLocalHost().getHostAddress()+"\",\"merchantDefineData\":{\"MDD1\":\"1\",\"MDD2\":\"2\",\"MDD3\":\"3\" } },\"channel\":\"web\",\"recurrenceMaxAmount\":\"1.00\"}";
            System.out.println(jsonParam);
            entity = new HttpEntity<>(jsonParam, headers);
            secResponseEntity = restTemplate.exchange(VISA_API_INIT_SESSION, HttpMethod.POST, entity, InitVisaDto.class);
            System.out.println("STATUS REST: "+secResponseEntity.getStatusCodeValue());
        } catch (Exception e) {
            System.out.println("** Exception: "+ e.getMessage());
            e.printStackTrace();
            return new ModelAndView("visa/pago");
        }

        InitVisaDto responseBatchVisa = secResponseEntity.getBody();
        //INYECTING VARIABLES
        model.addAttribute("ACTION", context.getAttribute("DOMAIN_NAME")+"p/pago/confirmacion");
        model.addAttribute("VISA_API_MERCHANT_ID", context.getAttribute("VISA_MERCHANT_ID").toString());
        model.addAttribute("LOGO_IMAGE", context.getAttribute("DOMAIN_NAME")+"imagen/visa_msa.png");
        model.addAttribute("SESSION_TOKEN", sessionToken);
        model.addAttribute("AMOUNT", BigDecimal.valueOf(amount).setScale(2));
        model.addAttribute("TRANSACTION_ID", ++id);//Por lo general acá va el ID de mi tabla
        model.addAttribute("SESSION_KEY", responseBatchVisa.getSessionKey());

        session.setAttribute("sessionToken", sessionToken);
        session.setAttribute("sessionFormatoId", id);//
        session.setAttribute("sessionMontoTUPA", amount);
        return new ModelAndView("visa/pago");
    }

    @PostMapping("/pago/confirmacion")
    public @ResponseBody
    ResponseVisaDto cierrePagoVisa(@RequestParam(name="transactionToken") String transactionToken, HttpSession session)
    {
        try {
            //Get session values
            String sessionToken = (String) session.getAttribute("sessionToken");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            String authVisa = context.getAttribute("VISA_API_KEY_ID") + ":" + context.getAttribute("VISA_API_KEY_PASSWORD");
            byte[] encodedAuth = Base64.encodeBase64(authVisa.getBytes(Charset.forName("US-ASCII")));
            String authHeader = "Basic " + new String( encodedAuth );
            headers.set("Authorization", authHeader);

            //ACCESS TO API SESSION

            RestTemplate restTemplate = new RestTemplate();

            String jsonParam = "{\"transactionToken\":\""+transactionToken+"\","
                    + "\"sessionToken\":\""+sessionToken+"\"}";
            HttpEntity<String> entity = new HttpEntity<>(jsonParam, headers);
            //ALL RESPONSE
            String responseApi = restTemplate.postForObject(context.getAttribute("VISA_API_POST").toString() + context.getAttribute("VISA_MERCHANT_ID").toString(), entity, String.class);
            System.out.println(("RESPONSE VISA API: "+ responseApi));

            Gson json = new Gson();
            return json.fromJson(responseApi, ResponseVisaDto.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseVisaDto();
        }
    }
}
