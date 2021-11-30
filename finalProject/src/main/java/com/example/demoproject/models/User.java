package com.example.demoproject.models;

import com.example.demoproject.enums.UserRole;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "td_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String fullname;
    private String email;
    private String password;
    private UserRole userRole;

    @OneToMany(mappedBy = "owner")
    private List<Job> jobs;


    @ManyToMany(mappedBy = "candidates")
    private List<Job> userCandidates;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRole getUserType() {
        return userRole;
    }

    public void setUserType(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Job> getUserCandidates() {
        return userCandidates;
    }

    public void setUserCandidates(List<Job> userCandidates) {
        this.userCandidates = userCandidates;
    }
}
