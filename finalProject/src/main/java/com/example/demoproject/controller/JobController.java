package com.example.demoproject.controller;

import com.example.demoproject.models.Job;
import com.example.demoproject.repositories.JobRepository;
import com.example.demoproject.wrapper.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/job")
public class JobController {

    public final static String WORKFLOW_CREATE_SUCCSESS    = "Workflow created successfully";
    public final static String WORKFLOW_UPDATE_SUCCSESS    = "Workflow updated successfully";
    public final static String WORKFLOW_REMOVE_SUCCSESS    = "Workflow removed successfully";
    public final static String WORKFLOW_NOT_FOUND          = "Workflow does not exist";

    @Autowired
    private JobRepository jobRepository;

    //Get Job
    @GetMapping("/")
    public ResponseEntity getAllJobs(){
       List<Job> httpResult = this.jobRepository.findAll();
       return ResponseMessage.success(httpResult);
    }
    @GetMapping("/{id}")
    public ResponseEntity getSingleJob(@PathVariable("id") int id){
        Optional<Job> httpResult = this.jobRepository.findById(id);
        if(httpResult.isPresent()){
            return  ResponseMessage.success(httpResult.get());
        }
        return ResponseMessage.notFound();
    }
    //TODO Add Job
    @PostMapping("/")
    public ResponseEntity createJob(@RequestBody Job entity){
       var httpResult = this.jobRepository.save(entity);
       return ResponseMessage.success(WORKFLOW_CREATE_SUCCSESS, httpResult);

    }
    //TODO Update Job
    @PostMapping("/{id}")
    public ResponseEntity updateJob(@RequestBody Job entity,@PathVariable("id") int id){
        Optional<Job> httpResult = this.jobRepository.findById(id);

        if (httpResult.isPresent()){
            Job existingEntity = httpResult.get();
            existingEntity.setName(entity.getName());
            existingEntity.setDescription(entity.getDescription());
            existingEntity.setJobStatus(entity.getJobStatus());
            existingEntity.setSalary(entity.getSalary());
            return ResponseMessage.success(WORKFLOW_UPDATE_SUCCSESS, existingEntity);
        }
        return ResponseMessage.notFound();
    }


    //TODO Delete Job
    @DeleteMapping("/{id}")
    public ResponseEntity deleteJob(@PathVariable("id") int id){
        Optional<Job> httpResult = this.jobRepository.findById(id);
        if (httpResult.isPresent()){
            this.jobRepository.deleteById(id);
            return ResponseMessage.success(WORKFLOW_REMOVE_SUCCSESS);
        }
        return ResponseMessage.notFound(WORKFLOW_NOT_FOUND);
    }
}
