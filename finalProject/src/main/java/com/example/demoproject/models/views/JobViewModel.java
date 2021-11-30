package com.example.demoproject.models.views;

import com.example.demoproject.enums.JobStatus;
import com.example.demoproject.enums.JobType;
import com.example.demoproject.models.User;

import javax.persistence.ManyToOne;

public class JobViewModel {
    private Long id;
    private String name;
    private JobType jobType;
    private int salary;
    private String description;
    private JobStatus jobStatus;
    private String ownerFullname;

    public JobViewModel() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getOwnerFullname() {
        return ownerFullname;
    }

    public void setOwnerFullname(String ownerFullname) {
        this.ownerFullname = ownerFullname;
    }
}
