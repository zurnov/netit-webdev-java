package com.example.demoproject.controller;

import com.example.demoproject.models.Job;
import com.example.demoproject.models.User;
import com.example.demoproject.models.views.JobViewModel;
import com.example.demoproject.repositories.JobRepository;
import com.example.demoproject.services.UserLogin;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;

@Controller
public class HtmlJobController {
    private String controllerPageTitle = "Job Panel";

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JobRepository jobRepository;

    @GetMapping("/htmlgetindex")
    public String getIndexPage(){
        return "index";
    }

    @GetMapping("/htmlgetjob")
    public String getJobPage(Model model){
        var jobCollection =
                Arrays.asList(this.modelMapper.map(this.jobRepository.findAll(), JobViewModel[].class));

        model.addAttribute("name", this.controllerPageTitle);
        model.addAttribute("collection",jobCollection);
        return "job";
    }

    @GetMapping("/htmlcreatejob")
    public String getCreateJob(Model model){
        Job entity = new Job();
        model.addAttribute("job",entity);
        return "create-job";
    }
    @PostMapping("/htmlsavejob")
    public RedirectView saveJob(@ModelAttribute Job entity){
        Authentication auth          = SecurityContextHolder.getContext().getAuthentication();
        UserLogin currentUserModel   = (UserLogin) auth.getPrincipal();
        User currentUser             = currentUserModel.getUser();

        entity.setOwner(currentUser);
        this.jobRepository.save(entity);
        return new RedirectView("/htmlgetjob");
    }


}
