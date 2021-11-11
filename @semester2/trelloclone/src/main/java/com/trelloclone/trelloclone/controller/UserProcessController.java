package com.trelloclone.trelloclone.controller;

import com.trelloclone.trelloclone.models.users.User;
import com.trelloclone.trelloclone.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class UserProcessController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/singup")
    public String getSingUpPage(Model model){
        model.addAttribute("user", new User());
        return "singup";

    }
    @GetMapping("/singin")
    public String getSingInPage(Model model){
        model.addAttribute("user", new User());
        return "singin";
    }

    @PostMapping("/authentication")
    public void processAuthentication(@ModelAttribute User user){
        Optional<User> dbUser = this.userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
        System.out.println("");



    }
    @PostMapping("/authorization")
    public RedirectView processAuthorization(@ModelAttribute User user){
        this.userRepository.save(user);
        return new RedirectView("/singin");
    }

}
