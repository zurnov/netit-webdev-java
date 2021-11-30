package com.example.demoproject.repositories;

import com.example.demoproject.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Integer> {
   // public Optional<Job> findJobById(int id);
    //find owner name by owner id
}
