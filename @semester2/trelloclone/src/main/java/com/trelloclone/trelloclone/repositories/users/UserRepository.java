package com.trelloclone.trelloclone.repositories.users;

import com.trelloclone.trelloclone.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
