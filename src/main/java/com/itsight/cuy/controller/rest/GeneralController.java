package com.itsight.cuy.controller.rest;

import com.itsight.cuy.domain.CardType;
import com.itsight.cuy.domain.DocumentType;
import com.itsight.cuy.domain.PersonType;
import com.itsight.cuy.domain.PlanType;
import com.itsight.cuy.domain.dto.DataResponseDTO;
import com.itsight.cuy.repository.ResidueParameterRepository;
import com.itsight.cuy.service.CardTypeService;
import com.itsight.cuy.service.DocumentTypeService;
import com.itsight.cuy.service.PersonTypeService;
import com.itsight.cuy.service.PlanTypeService;
import com.itsight.cuy.util.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/general")
public class GeneralController {
    private PlanTypeService planTypeService;
    private DocumentTypeService documentTypeService;
    private PersonTypeService personTypeService;
    private CardTypeService tipoTarjetaService;
    private ResidueParameterRepository residueParameterRepository;


    @Autowired
    public GeneralController(PlanTypeService planTypeService, DocumentTypeService documentTypeService, PersonTypeService personTypeService, CardTypeService tipoTarjetaService, ResidueParameterRepository residueParameterRepository) {
        this.planTypeService = planTypeService;
        this.documentTypeService = documentTypeService;
        this.personTypeService = personTypeService;
        this.tipoTarjetaService = tipoTarjetaService;
        this.residueParameterRepository = residueParameterRepository;
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

}
