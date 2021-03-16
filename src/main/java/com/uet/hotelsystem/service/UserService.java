package com.uet.hotelsystem.service;

import com.uet.hotelsystem.model.Provider;
import com.uet.hotelsystem.model.User;
import com.uet.hotelsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    @Transactional
     public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public void save(User userEntity){
        userRepository.save(userEntity);
    }

    @Transactional
    public Optional<User> getUserByEmailAndPassword(String email, String password){
         return userRepository.findByEmailAndPassword(email, password);
    }

    public void processOAuthPostLogin(String username) {
        User existUser = userRepository.getUserByUsername(username);

        if (existUser == null) {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setProvider(Provider.GOOGLE);
            newUser.setEnabled(true);

            userRepository.save(newUser);
            System.out.println("Created new user: " + username);
        }
    }
}