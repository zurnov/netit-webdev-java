package com.trelloclone.trelloclone.config;

import com.trelloclone.trelloclone.services.auth.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TrelloAuthenticationProvider {

    @Autowired
    private UserLoginService userLoginService;


    public DaoAuthenticationProvider provide() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(this.userLoginService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());

        return provider;
    }
}
