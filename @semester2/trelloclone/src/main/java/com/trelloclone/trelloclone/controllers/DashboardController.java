package com.trelloclone.trelloclone.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class DashboardController {
    @GetMapping("/dashboard")
    public String getDashboardPage(){
        return "main/dashboard";
    }
}
