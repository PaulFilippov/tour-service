package com.paul.controllers;

import com.paul.entities.User;
import com.paul.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping(value = {"/profile/{userId}"}, method = RequestMethod.GET)
    public User getUserById(@PathVariable Long userId) {
        User userById = userRepository.findById(userId).get();
        return userById;
    }


}

