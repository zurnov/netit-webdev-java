package com.example.demoproject.controller;


import com.example.demoproject.enums.UserRole;
import com.example.demoproject.models.User;
import com.example.demoproject.repositories.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserProcessController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
    public String getSignupPage(Model model) {

        model.addAttribute("user", new User());
        return "auth/signup";
    }

    @PostMapping("/signup")
    public RedirectView processAuthorization(@ModelAttribute User entity) {

        BCryptPasswordEncoder encoder 	= new BCryptPasswordEncoder();
        String strongPassword 			= encoder.encode(entity.getPassword());
        entity.setPassword(strongPassword);
        entity.setUserType(UserRole.WORKER);

        this.userRepository.save(entity);
        return new RedirectView("/signin");
    }


    @GetMapping("/signin")
    public String getSigninPage(Model model) {

        model.addAttribute("user", new User());
        return "auth/signin";
    }
}
