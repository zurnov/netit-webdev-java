package com.trelloclone.trelloclone.repositories.users;

import com.trelloclone.trelloclone.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    public Optional<User> findUserByEmailAndPassword(String email, String password);
}
