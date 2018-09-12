package com.paul.controllers;

import com.paul.models.Tour;
import com.paul.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
