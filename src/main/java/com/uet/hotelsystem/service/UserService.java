package com.uet.hotelsystem.service;

import com.uet.hotelsystem.model.UserEntity;
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
     public List<UserEntity> getAllUser(){
        return userRepository.findAll();
    }

    @Transactional
    public void addUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    @Transactional
    public Optional<UserEntity> getUserByEmailAndPassword(String email, String password){
         return userRepository.findByEmailAndPassword(email, password);
    }
}