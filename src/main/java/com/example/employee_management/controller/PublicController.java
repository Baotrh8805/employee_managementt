package com.example.employee_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_management.service.UtilityService;

//Dùng @RestController thay cho @Controller để trả về dữ liệu Json
@RestController
@RequestMapping("/api/public")
public class PublicController {

    private final UtilityService utilityService;

    public PublicController(UtilityService utilityService) {
        this.utilityService = utilityService;
    }

//    Mô-đun 1
    @GetMapping("/hello")
    public String hello(){
        return "Hello, Spring Boot!";
    }

//    Mô-đun 2
    @GetMapping("/generate-code")
    public String generateCode(){
        return utilityService.generateEmployeeCode();
    }

    @GetMapping("/format-name")
    public String formatName(@RequestParam String name){
        return utilityService.formatName(name);
    }
}
