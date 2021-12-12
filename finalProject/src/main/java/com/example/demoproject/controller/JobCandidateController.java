package com.example.demoproject.controller;

import com.example.demoproject.services.JobCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class JobCandidateController {

    @Autowired
    private JobCandidateService jobCandidateService;

    @GetMapping("/candidate")
    public  String getCandidatePageOLD(){

        return "candidate";
    }

    @GetMapping("job/candidate/{id}")
    public String getCandidatePage(@PathVariable int id, Model model){

        var jobCollection = this.jobCandidateService.getBoardsByWorkspace(id);
        model.addAttribute("jobCollection", jobCollection);
        model.addAttribute("jobId", id);

        return "candidate";
    }

    //For testing
    @GetMapping("/job/candidate/null")
    public String getCandidatePage(){

        return "error";
    }
}
