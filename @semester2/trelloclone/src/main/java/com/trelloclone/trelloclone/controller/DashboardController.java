package com.trelloclone.trelloclone.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class DashboardController {
    @GetMapping("/dashboard")
    public String getDashboardPage(){
        return "main/dashboard";
    }
}
