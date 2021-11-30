package com.example.demoproject.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.example.demoproject.models.User;

import com.example.demoproject.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserLoginService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> dbEntry = this.userRepository.findUserByEmail(username);
        if(dbEntry.isEmpty()) {
            throw new UsernameNotFoundException("This user is not available");
        }

        return new UserLogin(dbEntry.get());
    }
}

