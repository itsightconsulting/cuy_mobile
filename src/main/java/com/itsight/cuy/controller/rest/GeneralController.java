package com.itsight.cuy.controller.rest;

import com.itsight.cuy.domain.*;
import com.itsight.cuy.domain.dto.CardDTO;
import com.itsight.cuy.domain.dto.DataResponseDTO;
import com.itsight.cuy.domain.dto.TransactionDTO;
import com.itsight.cuy.repository.ResidueParameterRepository;
import com.itsight.cuy.repository.TransactionRepository;
import com.itsight.cuy.service.*;
import com.itsight.cuy.service.impl.TransactionServiceImpl;
import com.itsight.cuy.util.Enums;
import com.itsight.cuy.util.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/general")
public class GeneralController {
    private PlanTypeService planTypeService;
    private DocumentTypeService documentTypeService;
    private PersonTypeService personTypeService;
    private CardTypeService tipoTarjetaService;
    private TransactionService transactionService;
    private ResidueParameterRepository residueParameterRepository;


    @Autowired
    public GeneralController(PlanTypeService planTypeService, DocumentTypeService documentTypeService, PersonTypeService personTypeService, CardTypeService tipoTarjetaService, ResidueParameterRepository residueParameterRepository,TransactionService transactionService) {
        this.planTypeService = planTypeService;
        this.documentTypeService = documentTypeService;
        this.personTypeService = personTypeService;
        this.tipoTarjetaService = tipoTarjetaService;
        this.residueParameterRepository = residueParameterRepository;
        this.transactionService = transactionService;
    }

    @GetMapping("/listPlantType")
    public DataResponseDTO obtenerPlanes() {
        DataResponseDTO data = new DataResponseDTO();
        try {
            List<PlanType> lista;
            lista = planTypeService.findAll();
            data.setData(lista);
            data.setMessage("Success");
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS.get()));
            data.setFlag(true);
        } catch (Exception e) {
            data.setData(null);
            data.setMessage(e.getMessage());
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_GENERAL.get()));
            data.setFlag(false);
        }
        return data;
    }

    @GetMapping("/listDocumentType")
    public DataResponseDTO obtenerTipoDocumentos() {
        DataResponseDTO data = new DataResponseDTO();
        try {
            List<DocumentType> lista;
            lista = documentTypeService.findAll();
            data.setData(lista);
            data.setMessage("Success");
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS.get()));
            data.setFlag(true);
        } catch (Exception e) {
            data.setData(null);
            data.setMessage(e.getMessage());
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_GENERAL.get()));
            data.setFlag(false);
        }
        return data;
    }

    @GetMapping("/listPersonType")
    public DataResponseDTO obtenerTipoPersona() {
        DataResponseDTO data = new DataResponseDTO();
        try {
            List<PersonType> lista;
            lista = personTypeService.findAll();
            data.setData(lista);
            data.setMessage("Success");
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS.get()));
            data.setFlag(true);
        } catch (Exception e) {
            data.setData(null);
            data.setMessage(e.getMessage());
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_GENERAL.get()));
            data.setFlag(false);
        }
        return data;
    }

    @GetMapping("/listCardType")
    public DataResponseDTO obtenerTipoTarjeta() {
        DataResponseDTO data = new DataResponseDTO();
        try {
            List<CardType> lista;
            lista = tipoTarjetaService.findAll();
            data.setData(lista);
            data.setMessage("Success");
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS.get()));
            data.setFlag(true);
        } catch (Exception e) {
            data.setData(null);
            data.setMessage(e.getMessage());
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_GENERAL.get()));
            data.setFlag(false);
        }
        return data;
    }

    @GetMapping("/rangeToRecharges")
    public DataResponseDTO getMaximosParaRecargar() {
        DataResponseDTO data = new DataResponseDTO();
        try {
            data.setData(residueParameterRepository.findAll());
            data.setMessage("Success");
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS.get()));
            data.setFlag(true);
        } catch (Exception e) {
            data.setData(null);
            data.setMessage(e.getMessage());
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_GENERAL.get()));
            data.setFlag(false);
        }
        return data;
    }

    @GetMapping("/ccdiValidate/{iccdi}")
    public DataResponseDTO validarCCDI(@PathVariable(value = "iccdi") String iccdi) {
        DataResponseDTO data = new DataResponseDTO();
        try {
            if(iccdi.length() == 20){
                if(iccdi.chars().allMatch(Character::isDigit)){
                    data.setData(iccdi);
                    data.setMessage("Success");
                    data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS.get()));
                    data.setFlag(true);
                }else{
                    data.setData(null);
                    data.setMessage("CCDI incorrecto");
                    data.setResponseCode(Integer.parseInt(Enums.ResponseCode.DENIED.get()));
                    data.setFlag(false);
                }
            }else{
                data.setData(null);
                data.setMessage("CCDI incorrecto");
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

    @GetMapping("/associateDniToIccdi/{iccdi}/{dni}")
    public DataResponseDTO asociarDniACcdi(@PathVariable(value = "iccdi") String iccdi, @PathVariable(value = "dni") String dni) {
        DataResponseDTO data = new DataResponseDTO();
        try {
            boolean validate;
            validate = iccdi.length() == 20 ? true : false;
            validate = validate ? dni.length() == 8 ? true : false : false;
            validate = validate ? iccdi.chars().allMatch(Character::isDigit) ? true : false : false;
            validate = validate ? dni.chars().allMatch(Character::isDigit) ? true : false : false;

            if(validate){
                data.setData(iccdi);
                data.setMessage("Success");
                data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS.get()));
                data.setFlag(true);
            }else{
                data.setData(null);
                data.setMessage("Ccdi o dni incorrecto");
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

    @PostMapping(path = "/updateTransaction", consumes="application/json")
    public DataResponseDTO updateTransaction(@RequestBody TransactionDTO tra) {
        DataResponseDTO data = new DataResponseDTO();
        data.setFlag(false);
        try {

            Transaction transaction = transactionService.findByCodeTransaction(tra.getCodeTransaction());
            if (transaction != null) {
                transaction.setAmount(tra.getAmount());
                transaction.setDescription(tra.getDescription());
                transaction.setFlagCorrect(tra.isFlagCorrect());

                transactionService.update(transaction);
                data.setFlag(true);
                data.setData(null);
                data.setMessage("Success");
                data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS_UPDATE.get()));


            } else {
                data.setMessage("Transaccion no encontrado.");
                data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_NO_EXISTE.get()));
            }
        } catch (Exception e) {
            data.setData(null);
            data.setMessage(e.getMessage());
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_GENERAL.get()));
        }

        return data;
    }


}
