package com.itsight.cuy.controller.rest;

import com.itsight.cuy.domain.Operator;
import com.itsight.cuy.domain.dto.DataResponseDTO;
import com.itsight.cuy.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operator")
public class OperatorController {
    private OperatorService operatorService;

    @Autowired
    public OperatorController(OperatorService operatorService){
        this.operatorService = operatorService;
    }

    @GetMapping("/list")
    public DataResponseDTO obtenerOperadores(){
        DataResponseDTO data = new DataResponseDTO();
        try {
            List<Operator> lista = operatorService.findAll();
            data.setData(lista);
            data.setMessage("Success");
            data.setResponseCode(1);
            data.setFlag(true);
        }
        catch (Exception e){
            data.setData(null);
            data.setMessage(e.getMessage());
            data.setResponseCode(-500);
            data.setFlag(false);
        }
        return data;
    }

}
