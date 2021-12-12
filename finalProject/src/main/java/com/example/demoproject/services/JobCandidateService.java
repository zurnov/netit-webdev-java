package com.example.demoproject.services;

import com.example.demoproject.models.Job;
import com.example.demoproject.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class JobCandidateService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getBoardsByWorkspace(int id) {

        return this.jobRepository.findJobById(id);
    }
}
