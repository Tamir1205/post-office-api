package com.example.postofficeapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CheckController {
    @GetMapping("/check")
    public String postOfficeCheck() {
        return ("Post office api is working correctly");
    }
}
