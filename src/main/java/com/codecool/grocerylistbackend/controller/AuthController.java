package com.codecool.grocerylistbackend.controller;

import com.codecool.grocerylistbackend.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;



@RestController
public class AuthController {

    @Autowired
    AuthService authService;
    

    @GetMapping("/request_device_id")
    public String requestDeviceId(){
        UUID id = UUID.randomUUID();
        authService.registerNewId(id.toString());
        return id.toString();
    }

}
