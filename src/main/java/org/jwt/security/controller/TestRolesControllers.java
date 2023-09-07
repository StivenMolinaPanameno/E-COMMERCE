package org.jwt.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRolesControllers {
    @GetMapping("/accesAdmin")
    public String  accessAdmin(){
        return "Has accedido como administrador";
    }
    @GetMapping("/accesCustomer")
    public String  accessCustomers(){
        return "Has accedido como administrador";
    }
}
