package com.itsight.cuy.controller.rest;

import com.itsight.cuy.domain.Card;
import com.itsight.cuy.domain.CardType;
import com.itsight.cuy.domain.Person;
import com.itsight.cuy.domain.dto.CardDTO;
import com.itsight.cuy.domain.dto.CardPersonDTO;
import com.itsight.cuy.domain.dto.DataResponseDTO;
import com.itsight.cuy.service.CardService;
import com.itsight.cuy.service.CardTypeService;
import com.itsight.cuy.service.PersonService;
import com.itsight.cuy.util.Enums;
import com.itsight.cuy.util.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;
    private CardService cardService;
    private CardTypeService cardTypeService;

    @Autowired
    public PersonController(PersonService personService, CardService cardService, CardTypeService cardTypeService){
        this.personService = personService;
        this.cardService = cardService;
        this.cardTypeService = cardTypeService;
    }

    @GetMapping("/list")
    public DataResponseDTO obtenerPersons(){
        DataResponseDTO data = new DataResponseDTO();
        try {
            List<Person> lista = personService.findAll();
            data.setData(lista);
            data.setMessage("Success");
            data.setResponseCode(1);
            data.setFlag(true);
        } catch (Exception e){
            data.setData(null);
            data.setMessage(e.getMessage());
            data.setResponseCode(-500);
            data.setFlag(false);
        }
        return data;
    }

    @GetMapping("/listByDni")
    public DataResponseDTO getAllCards(@RequestParam String dni) {
        DataResponseDTO data = new DataResponseDTO();
        try {
            Person user = personService.findByDocumentNumber(dni);
            if(user != null)
            {
                if(user.isFlagActive()) {
                    List<Card> lista = cardService.findIdPersona(user.getId());
                    List<CardPersonDTO> mylist = new ArrayList<>();

                    if(lista.size() > 0) {

                        for (Card tj : lista){
                            CardPersonDTO obj = new CardPersonDTO();
                            obj.setCvv(tj.getCvv());
                            obj.setDescription(tj.getDescription());
                            obj.setDigits("*******"+tj.getDigitos().substring(8,12));

                            DateFormat dateFormat = new SimpleDateFormat("MM-yy");
                            String strDate = dateFormat.format(tj.getExpirationDate());
                            obj.setExpirationDate(strDate);

                            obj.setFlagFavorite(tj.isFlagFavorite());
                            obj.setCardType(tj.getCardType().getName());

                            obj.setPersonName(tj.getPerson().getName());
                            obj.setPersonDocumentNumber(tj.getPerson().getDocumentNumber());
                            obj.setDocumentTypeName(tj.getPerson().getDocumentType().getName());
                            mylist.add(obj);
                        }

                        data.setData(mylist);
                        data.setMessage("Success");
                        data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS.get()));
                        data.setFlag(true);
                    }else{

                        data.setMessage("No se encontraron registros.");
                        data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_SIN_REGISTROS.get()));
                        data.setFlag(false);
                    }
                }else{
                    data.setMessage("La cuenta del usuario no está activada.");
                    data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_DESHABILITADO.get()));
                    data.setFlag(false);
                }
            }
            else
                {
                data.setMessage("Usuario no encontrado.");
                data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_NO_EXISTE.get()));
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

    @GetMapping("/getFavoriteCard")
    public DataResponseDTO getCardFavorite(@RequestParam int id, @RequestParam int estado, @RequestParam String usuario ) {
        DataResponseDTO data = new DataResponseDTO();

        try {
            Card trj = cardService.findOne(id);
            if(trj != null) {
                trj.setFlagFavorite(estado == 1 ? true : false );
                trj.setModificationDate(new Date());
                trj.setModifiedBy(usuario);
                cardService.update(trj);

                data.setData(null);
                data.setMessage("Success");
                data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS.get()));
                data.setFlag(true);
            }
            else
            {
                data.setMessage("Card no encontrada.");
                data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_NO_EXISTE.get()));
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


    @PostMapping(path = "/addUpdateCard", consumes="application/json")
    private DataResponseDTO addUpdateCard(@RequestBody CardDTO card) {
        DataResponseDTO data = new DataResponseDTO();
        data.setFlag(false);
        try {
            Person user = personService.findByDocumentNumber(card.getPersonDni());
            if (user != null) {
                if (user.isFlagActive()) {

                    Card objexiste = cardService.findByPersonaIdByDigits(user.getId(), card.getDigits());
                    if (objexiste != null) {

                        Tuple<Boolean, String, Integer> flagValido = validateCard(card, true);
                        if (flagValido.item1) {
                            String sDate1 = "01/" + card.getExpirationDate().replace("-", "/");
                            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
                            objexiste.setExpirationDate(date1);
                            objexiste.setDescription(card.getDescription());
                            objexiste.setCvv(card.getCvv());

                            cardService.update(objexiste);
                            data.setFlag(true);
                            data.setData(null);
                            data.setMessage("Success");
                            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS_UPDATE.get()));
                        } else {
                            data.setMessage(flagValido.item2);
                            data.setResponseCode(flagValido.item3);
                        }
                    } else {
                        Tuple<Boolean, String, Integer> flagValido = validateCard(card, false);
                        if (flagValido.item1) {
                            CardType existetipo = cardTypeService.findOne(Integer.parseInt(card.getCardType()));
                            Card nuevatarjeta = new Card();
                            nuevatarjeta.setPerson(user.getId());
                            nuevatarjeta.setCardType(existetipo.getId());
                            nuevatarjeta.setCvv(card.getCvv());
                            nuevatarjeta.setDescription(card.getDescription());
                            nuevatarjeta.setDigitos(card.getDigits());

                            String sDate1 = "01/" + card.getExpirationDate().replace("-", "/");
                            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
                            nuevatarjeta.setExpirationDate(date1);
                            nuevatarjeta.setFlagFavorite(false);

                            cardService.save(nuevatarjeta);

                            data.setFlag(true);
                            data.setData(null);
                            data.setMessage("Success");
                            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS.get()));
                        } else {
                            data.setMessage(flagValido.item2);
                            data.setResponseCode(flagValido.item3);
                        }
                    }
                } else {
                    data.setMessage("La cuenta del usuario no está activada.");
                    data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_DESHABILITADO.get()));
                }
            } else {
                data.setMessage("Usuario no encontrado.");
                data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_NO_EXISTE.get()));
            }
        } catch (Exception e) {
            data.setData(null);
            data.setMessage(e.getMessage());
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_GENERAL.get()));
        }

        return data;
    }

    public Tuple<Boolean,String,Integer> validateCard(CardDTO item, Boolean editValidate) {
        Boolean exito = false;
        String mensajeSalida = "";
        Integer errorCode = -500;


        exito = !item.getPersonDni().isEmpty();
        exito = exito ? !item.getDigits().isEmpty() : exito;
        exito = exito ? !item.getDescription().isEmpty() : exito;
        exito = exito ? !item.getCvv().isEmpty() : exito;
        exito = exito ? !item.getExpirationDate().isEmpty() : exito;

        if (!editValidate) {
            exito = exito ? !item.getCardType().isEmpty() : exito;
        }

        if (exito) {

            if (item.getPersonDni().length() >= 8 && 15 >= item.getPersonDni().length()) {

            } else {
                mensajeSalida = "El número de documento debe tener entre 8 a 15 dígitos ";
                exito = false;
            }


            if (mensajeSalida.isEmpty() && item.getDigits().length() != 16) {
                mensajeSalida = "El número de tarjeta debe tener 16 dígitos ";
                exito = false;
            }

            if (mensajeSalida.isEmpty() && item.getCvv().length() != 3) {
                mensajeSalida = "El CCV debe tener 3 dígitos ";
                exito = false;
            }

            DateFormat dateFormat = new SimpleDateFormat("MM-yy");
            String formato = dateFormat.format(new Date());

            String regex = "^(1[0-2]|0[1-9])-[0-9]{2}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(item.getExpirationDate());

            if (mensajeSalida.isEmpty() && !matcher.matches()) {
                mensajeSalida = "La fecha de expiración no tiene el formato correcto. Ejem : " + formato;
                exito = false;
            }

            if (!editValidate && mensajeSalida.isEmpty()) {
                CardType existetipo = cardTypeService.findOne(Integer.parseInt(item.getCardType()));
                if (existetipo == null) {
                    mensajeSalida = "El tipo de tarjeta no existe";
                    exito = false;
                }
            }

            if (!exito) {
                errorCode = Integer.parseInt(Enums.ResponseCode.ERROR_DATOS.get());
            }

        } else {

            mensajeSalida = item.getPersonDni().isEmpty() ? "Debe ingresar el número de documento" : "";
            mensajeSalida = mensajeSalida.isEmpty() && item.getDigits().isEmpty() ? "Debe de ingresar los dígitos" : mensajeSalida;
            mensajeSalida = mensajeSalida.isEmpty() && item.getDescription().isEmpty() ? "Debe de ingresar una descripción" : mensajeSalida;
            mensajeSalida = mensajeSalida.isEmpty() && item.getCvv().isEmpty() ? "Debe ingresar el CCV" : mensajeSalida;
            mensajeSalida = mensajeSalida.isEmpty() && item.getExpirationDate().isEmpty() ? "Debe ingresar la fecha vencimiento" : mensajeSalida;

            if (!editValidate) {
                mensajeSalida = mensajeSalida.isEmpty() && item.getCardType().isEmpty() ? "Debe un tipo de Tarjeta" : mensajeSalida;
            }

            errorCode = Integer.parseInt(Enums.ResponseCode.ERROR_FALTAN_DATOS.get());
        }
        return new Tuple<Boolean, String, Integer>(exito, mensajeSalida, errorCode);
    }
}
