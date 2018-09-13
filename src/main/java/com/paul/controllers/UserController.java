package com.paul.controllers;

import com.paul.entities.User;
import com.paul.repositories.UserRepository;
import com.paul.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserRepository userRepository;
    private UserService userService = new UserService();
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping(value = {"/profile/{userId}"}, method = RequestMethod.GET)
    public User getUserById(@PathVariable Long userId) {
        User userById = userRepository.findById(userId).get();
        //System.out.println(userService.getAllUser()+"/n");
        return userById;
    }


}

