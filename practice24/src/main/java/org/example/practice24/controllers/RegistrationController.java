package org.example.practice24.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.practice24.entities.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class RegistrationController {

    @Autowired
    private InMemoryUserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customUser", new CustomUser());
        return "registration-form";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("customUser") CustomUser user) {
        if (userDetailsManager.userExists(user.getName())) {
            log.info("!!! ERROR !!!");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        userDetailsManager.createUser(new User(user.getName(), encodedPassword, List.of(new SimpleGrantedAuthority("SIMPLE_USER"))));
        return "redirect:/login";
    }
}