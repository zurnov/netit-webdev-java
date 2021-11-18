package com.trelloclone.trelloclone.controllers;

import com.trelloclone.trelloclone.models.pm.Workspace;
import com.trelloclone.trelloclone.repositories.pm.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HtmlWorkspaceController {

   private String controllerPageTitle = "Workspace Panel";

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @GetMapping("/htmlgetindex")
    public String getIndexPage(){
        return "index";
    }
    @GetMapping("/htmlworkspace")
    public String getWorkspacePage(Model model){
        var workspaceCollection = this.workspaceRepository.findAll();

        model.addAttribute("title", this.controllerPageTitle);
        model.addAttribute("collection", workspaceCollection);
        return "workspace";
    }
    @GetMapping("/htmlcreateworkspace")
    public String getCreateWorkspace(Model model){
        Workspace entity = new Workspace();
        model.addAttribute("workspace", entity);
//        return "/create-workspace"; Pozvam go susthto v DashboardController
        return "main/create-workspace";
    }
    @PostMapping("/htmlsaveworkspace")
    public RedirectView saveWorkspace(@ModelAttribute Workspace entity){

        this.workspaceRepository.save(entity);
        return new RedirectView("/htmlworkspace");
    }
}
