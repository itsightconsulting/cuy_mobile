package com.itsight.cuy.controller;

import com.google.gson.Gson;
import com.itsight.cuy.domain.dto.InitVisaDto;
import com.itsight.cuy.domain.dto.ResBaseRechargeCuy;
import com.itsight.cuy.domain.dto.ResponseVisaDto;
import com.itsight.cuy.service.ParameterService;
import com.itsight.cuy.util.Utilitarios;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/k")
public class KasNetProcessController {

    private static volatile SecureRandom numberGenerator = null;
    private static final long MSB = 0x8000000000000000L;
    private static int id = 83;

    @Autowired
    private ServletContext context;

    @Autowired
    private ParameterService parameterService;


    @GetMapping("/pago")
    public ModelAndView vistaObtenerAmount(Model model, HttpSession session) {
        SecureRandom ng = numberGenerator;
        if (ng == null) {
            numberGenerator = ng = new SecureRandom();
        }

        double amount = Double.parseDouble(context.getAttribute("RECHARGE_AMOUNT_K").toString());
        ResponseEntity<String> response;
        String authVisa = context.getAttribute("VISA_API_KEY_ID") + ":" + context.getAttribute("VISA_API_KEY_PASSWORD");
        byte[] encodedAuth = Base64.encodeBase64(authVisa.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String( encodedAuth );

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
        try{
            String VISA_API_INIT_SESSION = context.getAttribute("VISA_API_INIT_SESSION").toString() + context.getAttribute("VISA_MERCHANT_ID").toString();
            String jsonParam =
                    "{\"amount\": \""+amount+"\",\"antifraud\":{\"clientIp\":\""+ InetAddress.getLocalHost().getHostAddress()+"\",\"merchantDefineData\":{\"MDD1\":\"1\",\"MDD2\":\"2\",\"MDD3\":\"3\" } },\"channel\":\"web\",\"recurrenceMaxAmount\":\""+amount+"\"}";
            System.out.println(jsonParam);
            entity = new HttpEntity<>(jsonParam, headers);
            secResponseEntity = restTemplate.exchange(VISA_API_INIT_SESSION, HttpMethod.POST, entity, InitVisaDto.class);
            System.out.println("STATUS REST : "+secResponseEntity.getStatusCodeValue());

        }catch (HttpStatusCodeException e) {
            System.out.println(e.getResponseBodyAsString());
            return new ModelAndView("kasnet/pago");
        }
        catch (Exception e) {
            System.out.println("** Exception: "+ e.getMessage());
            e.printStackTrace();
            return new ModelAndView("kasnet/pago");
        }

        InitVisaDto responseBatchVisa = secResponseEntity.getBody();
        //INYECTING VARIABLES
        model.addAttribute("ACTION", context.getAttribute("DOMAIN_NAME")+"k/pago/confirmacion");
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

        return new ModelAndView("kasnet/pago");
    }


    @PostMapping("/pago/confirmacion")
    public ModelAndView confirmacionPagoVisa(@RequestParam(name="transactionToken") String transactionToken, Model model,  HttpSession session)
    {
        //4919148107859067 | accept@cybersource.com
        System.out.println("TRANSACTION TOKEN: >>>> "+transactionToken);
        try {
            //Get session values
            //String sessionToken = (String) session.getAttribute("sessionToken");
            String securityVisaCode = (String) session.getAttribute("SESSION_TOKEN_SEC");
            double amount = Double.parseDouble(context.getAttribute("RECHARGE_AMOUNT_K").toString());
            String numint = context.getAttribute("NUMBER_AMOUNT_K").toString();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", securityVisaCode);

            //ACCESS TO API SESSION |

            RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
            String jsonParam = "{\"antifraud\":null,\"captureType\":\"manual\",\"cardHolder\":{\"documentNumber\":\"12345678\",\"documentType\":\"0\"},\"channel\":\"web\",\"countable\":true,\"order\":{\"amount\":\""+amount+"\",\"currency\":\"PEN\",\"productId\":\""+id+"\",\"purchaseNumber\":\""+id+"\",\"tokenId\":\""+transactionToken+"\"},\"recurrence\":{\"amount\":\""+amount+"\",\"beneficiaryId\":\"602545705\",\"frequency\":\"MONTHLY\",\"maxAmount\":\""+amount+"\",\"type\":\"FIXED\"},\"terminalId\":\"1\",\"terminalUnattended\":false}}";

            HttpEntity<String> entity = new HttpEntity<>(jsonParam, headers);
            //ALL RESPONSE
            String responseApi = restTemplate.postForObject(context.getAttribute("VISA_API_TRANSACT").toString() + context.getAttribute("VISA_MERCHANT_ID").toString(), entity, String.class);
            System.out.println(("RESPONSE VISA API: "+ responseApi));
            Gson json = new Gson();
            ResponseVisaDto res = json.fromJson(responseApi, ResponseVisaDto.class);


            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmm");
            String datestr = sf.format(new Date());

            model.addAttribute("NUMBER_K", numint);
            model.addAttribute("AMOUNT_K", amount);
            model.addAttribute("DATE_TODAY", datestr);
            model.addAttribute("CODE", res.getDataMap().getTRANSACTION_ID());


            return new ModelAndView("kasnet/crear_pago");

        }catch (HttpStatusCodeException e) {
            System.out.println(e.getResponseBodyAsString());
            return new ModelAndView("redirect:/p/visa/fallo");

        }
        catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("redirect:/p/visa/fallo");
        }
    }
}
