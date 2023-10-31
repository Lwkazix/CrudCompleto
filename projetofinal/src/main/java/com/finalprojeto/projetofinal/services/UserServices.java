package com.finalprojeto.projetofinal.services;


import com.finalprojeto.projetofinal.models.UserModels;
import com.finalprojeto.projetofinal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices{
    @Autowired
     private UserRepository ur;

    public UserModels save(UserModels userModels){
        return ur.save(userModels);
    }
    public List<UserModels> findAll(){
        return ur.findAll();
    }
    public Optional<UserModels> findById(Integer id){
        return ur.findById(id);
    }
    public void deletById(Integer id){
        ur.deleteById(id);

    }
}

