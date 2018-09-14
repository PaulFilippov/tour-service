package com.paul.controllers;

import com.paul.entities.User;
import com.paul.repositories.UserRepository;
import com.paul.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@Controller
public class UserController {

    //@Autowired
    private UserRepository userRepository;
    //@Autowired
    private UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    //отображение профиля юзера
    @GetMapping(value = "/profile")
    public String showUserProfile(ModelMap model) {
        User user = userService.getCurAuthUser();
        model.addAttribute("user", user);
        // System.out.println("Все туры: "+tourService.getAllTour()+"/n");
        return "profile";
    }

    //обработка изменения профиля
    @PostMapping(value = "/profile")
    @ModelAttribute (value = "user")
    public String changeUserProfile(User user, BindingResult bindingResult,  ModelMap model) {
        System.out.println("Контроллер изменения профиля ");
        Object us = model.get("user");
        System.out.println(us);
        System.out.println(user);
        System.out.println(bindingResult);
        System.out.println(model);
        userService.updateUserPforile(user);
        System.out.println("Контроллер изменения профиля2 ");
        model.addAttribute("first_name", user.getFirst_name());
        model.addAttribute("last_name", user.getLast_name());
        model.addAttribute("birthday", user.getBirthday());
        //User userById = userRepository.findById(userId).get();
        //System.out.println(userService.getAllUser()+"/n");
//        ModelMap model = new ModelMap();
//        User updatedProfile=userService.getCurAuthUser();
//        model.addAttribute(updatedProfile);
        return "profile";
    }

}

