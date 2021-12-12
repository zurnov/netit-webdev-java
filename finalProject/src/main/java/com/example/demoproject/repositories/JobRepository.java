package com.example.demoproject.repositories;

import com.example.demoproject.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Integer> {
   @Query(value = "SELECT * FROM td_jobs", nativeQuery = true)
   public List<Job> findJobById(int id);
}
