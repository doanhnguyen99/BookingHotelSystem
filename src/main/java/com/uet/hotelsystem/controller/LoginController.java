package com.uet.hotelsystem.controller;

import com.uet.hotelsystem.model.UserEntity;
import com.uet.hotelsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public String registerUser(String userName, String email, String password,
                               String rePassword){
        if(!password.equals(rePassword)){
//            System.out.println(password + "       " + rePassword);
            return "redirect:register?error";
        }else{
            UserEntity newUser = new UserEntity();
            newUser.setUserName(userName);
            newUser.setEmail(email);
            newUser.setPassword(password);
//            System.out.println(newUser);
            userService.addUser(newUser);
            return "redirect:login?success";
        }
    }


    @PostMapping("/loginUser")
    public String loginUser(String email, String password){
        Optional<UserEntity> loginUser = userService.getUserByEmailAndPassword(email, password);
        if(loginUser.isEmpty()){
            return "redirect:login?error";
        }else{
            return "redirect:index";
        }
    }
}