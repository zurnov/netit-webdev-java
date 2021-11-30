package com.example.demoproject.repositories;

import com.example.demoproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findUserByEmailAndPassword(String email, String password);
    public Optional<User> findUserByEmail(String email);
}
