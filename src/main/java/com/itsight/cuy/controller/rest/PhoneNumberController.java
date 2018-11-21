package com.itsight.cuy.controller.rest;

import com.itsight.cuy.domain.Person;
import com.itsight.cuy.domain.dto.DataResponseDTO;
import com.itsight.cuy.service.PersonService;
import com.itsight.cuy.service.RechargeService;
import com.itsight.cuy.util.Enums;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phone-number")
public class PhoneNumberController {

    private RechargeService rechargeService;
    private PersonService personService;

    public PhoneNumberController(RechargeService rechargeService, PersonService personService){
        this.rechargeService = rechargeService;
        this.personService = personService;
    }

    @GetMapping("/getLastTenRechargesByNumber/{phoneNumber}")
    public DataResponseDTO obtenerUltimas10RechargasByNumber(@PathVariable(name = "phoneNumber") String phoneNumber){
        DataResponseDTO data = new DataResponseDTO();
        try {
            if(phoneNumber.length() == 9){
                if(phoneNumber.chars().allMatch(Character::isDigit)){
                    data.setData(rechargeService.findAllByNumber(phoneNumber));
                    data.setMessage("Success");
                    data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS.get()));
                    data.setFlag(true);
                }else{
                    data.setData(null);
                    data.setMessage("Número incorrecto");
                    data.setResponseCode(Integer.parseInt(Enums.ResponseCode.DENIED.get()));
                    data.setFlag(false);
                }
            }else{
                data.setData(null);
                data.setMessage("Número incorrecto");
                data.setResponseCode(Integer.parseInt(Enums.ResponseCode.DENIED.get()));
                data.setFlag(false);
            }
        } catch (Exception e) {
            data.setData(null);
            data.setMessage(e.getMessage());
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_GENERAL.get()));
            data.setFlag(false);
        }
        return data;
    }


    @GetMapping("/getListPhoneNumberByIDDocument/{dni}")
    public DataResponseDTO obtenerListadoTelefonosPorDocumentoIdentidad(@PathVariable(name = "dni") String dni) {
        DataResponseDTO data = new DataResponseDTO();
        try {
            if (dni.chars().allMatch(Character::isDigit)) {
                Person user = personService.findByDocumentNumber(dni);
                if (user != null) {
                    data.setData(personService.findAllPhoneNumberByDocumentNumber(user.getId()));
                    data.setMessage("Success");
                    data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS.get()));
                    data.setFlag(true);
                } else {
                    data.setData(null);
                    data.setMessage("Usuario no encontrado");
                    data.setResponseCode(Integer.parseInt(Enums.ResponseCode.DENIED.get()));
                    data.setFlag(false);
                }
            } else {
                data.setData(null);
                data.setMessage("Número incorrecto");
                data.setResponseCode(Integer.parseInt(Enums.ResponseCode.DENIED.get()));
                data.setFlag(false);
            }
        } catch (Exception e) {
            data.setData(null);
            data.setMessage(e.getMessage());
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_GENERAL.get()));
            data.setFlag(false);
        }
        return data;
    }


}
