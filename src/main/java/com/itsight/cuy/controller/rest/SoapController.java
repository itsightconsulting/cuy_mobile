package com.itsight.cuy.controller.rest;

import com.itsight.cuy.ws.BLZServiceStub;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/soap")
public class SoapController {

    @GetMapping("/bank/{codeBank}")//38070059|21530080|more... https://blz.bankingdb.com/search?bank_name=A&swift_code=&blz_code=&search=Search
    public BLZServiceStub.DetailsType obtenerBancoAleman(@PathVariable(value = "codeBank") String codeBank){
        try {
            BLZServiceStub blz = new BLZServiceStub();
            BLZServiceStub.GetBank bank = new BLZServiceStub.GetBank();
            BLZServiceStub.GetBankType gbt = new BLZServiceStub.GetBankType();
            gbt.setBlz(codeBank);
            bank.setGetBank(gbt);
            return blz.getBank(bank).getGetBankResponse().getDetails();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new BLZServiceStub.DetailsType();
    }

}
