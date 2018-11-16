package com.itsight.cuy.controller.rest;

import com.itsight.cuy.domain.dto.DataResponseDTO;
import com.itsight.cuy.service.CardService;
import com.itsight.cuy.util.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {


    private CardService cardService;

    @Autowired
    public CardController(CardService cardService){
        this.cardService = cardService;
    }

    @DeleteMapping("/removeByIdAndPersonId/{cardId}/{personId}")
    public DataResponseDTO eliminarSegunIdAndPersonaId(@PathVariable(name = "cardId") int id, @PathVariable(name = "personId") int personId){
        DataResponseDTO data = new DataResponseDTO();
        try {
            if(cardService.getPersonIdById(id) == personId){
                cardService.delete(id);
                data.setData(null);
                data.setMessage("Success");
                data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS.get()));
                data.setFlag(true);
            }else{
                data.setData(null);
                data.setMessage("Los ids no se encuentran relacionados");
                data.setResponseCode(Integer.parseInt(Enums.ResponseCode.DENIED.get()));
                data.setFlag(false);
            }
        }
        catch (Exception e){
            data.setData(null);
            data.setMessage(e.getMessage());
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_GENERAL.get()));
            data.setFlag(false);
        }
        return data;
    }
}
