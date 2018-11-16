package com.itsight.cuy.controller.rest;

import com.itsight.cuy.domain.PersonPlan;
import com.itsight.cuy.domain.dto.DataResponseDTO;
import com.itsight.cuy.domain.jsonb.Preferences;
import com.itsight.cuy.service.PersonPlanService;
import com.itsight.cuy.service.PersonService;
import com.itsight.cuy.service.PlanService;
import com.itsight.cuy.util.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {

    private PlanService planService;

    private PersonPlanService personPlanService;

    private PersonService personService;

    @Autowired
    public PlanController(PlanService planService, PersonPlanService personPlanService, PersonService personService){
        this.planService = planService;
        this.personPlanService = personPlanService;
        this.personService = personService;
    }

    @GetMapping("/list")
    public DataResponseDTO obtenerPlanesActivos(){
        DataResponseDTO data = new DataResponseDTO();
        try {
            data.setData(planService.findAll());
            data.setMessage("Success");
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS.get()));
            data.setFlag(true);
        }
        catch (Exception e){
            data.setData(null);
            data.setMessage(e.getMessage());
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_GENERAL.get()));
            data.setFlag(false);
        }
        return data;
    }

    @GetMapping("/listByPersonId/{personId}")
    public DataResponseDTO obtenerPlanesSegunPersonId(@PathVariable(name = "personId") int personId){
        DataResponseDTO data = new DataResponseDTO();
        try {
            List<PersonPlan> lstPersonPlan =  personPlanService.findByPersonId(personId);
            if(!lstPersonPlan.isEmpty()){
                data.setData(personPlanService.findByPersonId(personId));
                data.setMessage("Success");
                data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS.get()));
                data.setFlag(true);
            }else{
                data.setData(null);
                data.setMessage("No se encontraron planes para la persona");
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

    @GetMapping("/getCustom")
    public DataResponseDTO obtenerPrecioPlanCustomizado(@RequestParam(name = "min") int min, @RequestParam(name = "mbs") int mbs, @RequestParam(name = "sms") int sms){
        DataResponseDTO data = new DataResponseDTO();
        try {
            /*String jsonString = "{\"rechargeAmount\":"+(min * 0.55) + (mbs * 1.17) + (sms * 0.1)+"}";
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rechargeAmountObj = mapper.readTree(jsonString);*/
            if(min>0 && mbs > 0 && sms > 0){
                data.setData("{\"rechargeAmount\":"+(min * 0.55) + (mbs * 1.17) + (sms * 0.1)+"}");
                data.setMessage("Success");
                data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS.get()));
                data.setFlag(true);
            }else{
                data.setData(null);
                data.setMessage("Datos inválidos ingresados");
                data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_GENERAL.get()));
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

    @GetMapping("/getCustomPlans/{personId}")
    public DataResponseDTO obtenerPlanes(@PathVariable(name = "personId") int personId){
        DataResponseDTO data = new DataResponseDTO();
        try {
            Preferences preferences = personService.findPlanPreferencesById(personId);
            if(!(preferences == null)){
                data.setData(preferences);
                data.setMessage("Success");
                data.setResponseCode(Integer.parseInt(Enums.ResponseCode.SUCCESS.get()));
                data.setFlag(true);
            }else{
                data.setData(null);
                data.setMessage("No se encontraron planes para la persona");
                data.setResponseCode(Integer.parseInt(Enums.ResponseCode.DENIED.get()));
                data.setFlag(false);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(">>>1");
            data.setData(null);
            data.setMessage(e.getMessage());
            data.setResponseCode(Integer.parseInt(Enums.ResponseCode.ERROR_GENERAL.get()));
            data.setFlag(false);
        }
        return data;
    }
}
