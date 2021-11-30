package com.example.demoproject.models;

import com.example.demoproject.enums.JobStatus;
import com.example.demoproject.enums.JobType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "td_jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private JobType jobType;
    private int salary;
    private String description;
    private JobStatus jobStatus;

    @ManyToOne()
    private User owner;

    @ManyToMany
    @JoinTable(
            name                = "tc_job_candidates",
            joinColumns         = @JoinColumn(name = "job_id"),
            inverseJoinColumns  = @JoinColumn(name = "user_id")
    )
    private List<User> candidates;

    public Job() {
    }

    public Job(String name, JobType jobType, int salary, String description, JobStatus jobStatus) {
        this.name = name;
        this.jobType = jobType;
        this.salary = salary;
        this.description = description;
        this.jobStatus = jobStatus;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<User> candidates) {
        this.candidates = candidates;
    }
}
