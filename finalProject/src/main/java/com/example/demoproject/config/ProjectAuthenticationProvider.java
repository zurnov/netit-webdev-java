package com.example.demoproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demoproject.services.UserLoginService;

@Service
public class ProjectAuthenticationProvider {

    @Autowired
    private UserLoginService userLoginService;


    public DaoAuthenticationProvider provide() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(this.userLoginService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());

        return provider;
    }

}