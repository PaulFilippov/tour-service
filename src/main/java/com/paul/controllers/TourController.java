package com.paul.controllers;

import com.paul.entities.Tour;
import com.paul.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class TourController {

    @Autowired
    private TourService tourService;



    @GetMapping(value = "/tours")
    public String showAllTours(ModelMap model) {
        Set <Tour> allTours = tourService.getAllTour();
        model.addAttribute("allTours", allTours);
        return "tours";
    }

}
