package com.itsight.cuy.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cuy")
public class CuyController {

    //	@PreAuthorize("hasAnyRole({'ADMIN','USER'}) or hasAuthority('READ_PRIVILEGE')")
    @GetMapping(value = {"/d"})
    public String welcomeFirstRest() {
        return "Demo rest controller";
    }
}
