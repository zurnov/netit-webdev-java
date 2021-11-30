package com.example.demoproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class DashboardController {
    @GetMapping("/dashboard")
    public String getDashboardPage(Model model) {

//        this.workspaceCollection = this.workspaceDataService.getAllWorkspaces();
//        model.addAttribute("collection", this.workspaceCollection);
        return "/dashboard";
    }
}
