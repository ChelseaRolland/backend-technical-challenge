package com.backend.technical.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees/")
public class RestEmployeeController {

    @GetMapping("/get")
    public String getEmployee(){
        return "Hello there";
    }

}
