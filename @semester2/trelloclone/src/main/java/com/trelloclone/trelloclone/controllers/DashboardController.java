package com.trelloclone.trelloclone.controllers;

import com.trelloclone.trelloclone.models.pm.Workspace;
import com.trelloclone.trelloclone.repositories.pm.WorkspaceRepository;
import com.trelloclone.trelloclone.services.auth.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DashboardController {
    @Autowired
    private WorkspaceRepository workspaceRepository;

    @GetMapping("/dashboard")
    public String getDashboardPage(){
        return "main/dashboard";
    }

    @GetMapping("/create-workspace")
    public String getCreateWorkspacePage(Model model){
        model.addAttribute(new Workspace());
        return "main/create-workspace";
    }
    @PostMapping("/create-workspace")
    public RedirectView createWorkspace(@ModelAttribute Workspace entity, Authentication auth){

        UserLogin authUser = (UserLogin) auth.getPrincipal();
        //SEGA GET USER ID
        this.workspaceRepository.save(entity);
       return new RedirectView("/dashboard");
    }
}
