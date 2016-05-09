package com.cenyol.example.controller;

import com.cenyol.example.model.UserEntity;
import com.cenyol.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by sjj on 2015/10/24 0024.
 */
@Controller
public class MainController {


    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(ModelMap modelMap){

        List<UserEntity> userEntityList = userRepository.findAll();


        modelMap.addAttribute("userList", userEntityList);


        return "userManage";
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(){
        return "addUser";
    }


    @RequestMapping(value = "/addUserPost", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") UserEntity userEntity){

        userRepository.saveAndFlush(userEntity);


        return "redirect:/users";
    }


    @RequestMapping(value = "/showUser/{userId}", method = RequestMethod.GET)
    public String showUser( @PathVariable("userId") Integer userId, ModelMap modelMap ){
        UserEntity userEntity = userRepository.findOne(userId);
        modelMap.addAttribute("user", userEntity);
        return "userDetail";
    }


    @RequestMapping(value = "/updateUser/{userId}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("userId") Integer userId, ModelMap modelMap){
        UserEntity userEntity = userRepository.findOne(userId);
        modelMap.addAttribute("user", userEntity);
        return "updateUser";
    }

    @RequestMapping(value = "/updateUserPost", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("user") UserEntity userEntity){
        userRepository.updateUser(
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getPassword(),
                userEntity.getId()
        );
        return "redirect:/users";
    }


    @RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("userId") Integer userId){

        userRepository.delete(userId);

        userRepository.flush();
        return "redirect:/users";
    }
}