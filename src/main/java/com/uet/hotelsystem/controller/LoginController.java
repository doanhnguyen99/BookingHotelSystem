package com.uet.hotelsystem.controller;

import com.uet.hotelsystem.model.User;
import com.uet.hotelsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public String registerUser(String username, String email, String password,
                               String rePassword) {
        if (!password.equals(rePassword)) {
            return "redirect:register?error";
        } else {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setEmail(email);
            newUser.setEnabled(true);
            newUser.setRole("ROLE_USER");
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            password = encoder.encode(password);
            newUser.setPassword(password);
            userService.save(newUser);
            return "redirect:login?success";
        }
    }
}