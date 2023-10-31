package com.finalprojeto.projetofinal.controllers;

import com.finalprojeto.projetofinal.models.UserModels;
import com.finalprojeto.projetofinal.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/central")
public class ReplaceControllers {

    @Autowired
    private UserServices us;

    @GetMapping(value = "/about")
    public String atTry(){
        return "about/sobre";
    }
    @GetMapping(value = "/classic")
    public String btTry(){
        return "classic/index";
    }
    @GetMapping(value = "/ps4")
    public String ctTry(){
        return "ps4/ps4";
    }
    @GetMapping(value = "/ps5")
    public String dtTry(){
        return "ps5/ps5";
    }
    @GetMapping(value = "/xbox")
    public String etTry(){
        return "xbox/xbox";
    }
    @GetMapping(value = "/xboxs")
    public String ftTry(){
        return "xboxs/xboxs";
    }
    @GetMapping(value = "/switch")
    public String gTry(){
        return "switch/switch";
    }
    @GetMapping(value = "/store")
    public String hTry(){
        return "store/loja";
    }
    @GetMapping(value = "/register")
    public String firstTry(){
        return "register/cadastro";
    }
    @GetMapping
    public String getAllUser(Model model){
        List<UserModels> users = us.findAll();
        model.addAttribute("users",users);
        return "users/users";
    }
    @PostMapping(value = "/cadastrar")
    public String saveUser(UserModels userModels){
        us.save(userModels);
        return "redirect:/central";
    }
    @GetMapping(value = "/{id}")
    public String getUserById(@PathVariable Integer id, Model model){
        Optional<UserModels> user = us.findById(id);
        if (user.isPresent()){
            model.addAttribute("user",user.get());
            return "users/update";
        }else {
        return "redirect:/central";
        }
    }
    @PostMapping(value = "/update/{id}")
    public String updateUser( @PathVariable Integer id, UserModels userModels){
        Optional<UserModels> user = us.findById(id);
        if (user.isPresent()){
            us.save(userModels);
            return "redirect:/central";
        }else {
            return "redirect:/central";
        }
    }
    @GetMapping(value = "/delete/{id}")
    public String deleteUserById(@PathVariable Integer id){
        us.deletById(id);
        return "redirect:/central";
    }
}
