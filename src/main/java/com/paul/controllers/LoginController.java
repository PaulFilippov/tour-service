package com.paul.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    public LoginController() {
    }

    @GetMapping(value = { "/", "/login" })
    public String showLoginPage(Model model) {
        return "login";
    }


    @PostMapping(value = "/login")
    public String userAuthorization(Model model) {
        model.addAttribute("user", model);
        return "/tours";

    }

//    @GetMapping(value="/logout")
//    public String logout (HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
//    }


}
