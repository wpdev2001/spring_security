package com.security.wp.SpringSecurityCode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/route1")
    public String route1(Principal principal){
        return "projected route 1 " + principal.getName();
    }

    @GetMapping("/route2")
    public String route2(){
        return "projected route 2";
    }

}
