package com.paul.controllers;

import com.paul.entities.Order;
import com.paul.entities.Tour;
import com.paul.services.OrderService;
import com.paul.services.TourService;
import com.paul.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@Controller
public class TourController {

    @Autowired
    private TourService tourService;
    private OrderService orderService = new OrderService();
    private UserService userService = new UserService();

    @GetMapping(value = "/tours")
    public String showAllTours(ModelMap model) {
        Set <Tour> allTours = tourService.getAllTour();
        model.addAttribute("allTours", allTours);
        System.out.println("Все туры: "+tourService.getAllTour()+"/n");
        return "tours";
    }

    //добавить выбранный тур в заказы текущего юзера
    @GetMapping(value = "/orderTourByUser/{id_tour}")
    public void addTourToUser(@PathVariable("id_tour") Long id_tour, ModelMap model) {
        Tour selectedTour = tourService.getTourById(id_tour);
        System.out.println("Инфа тура по айди"+ selectedTour);
        orderService.createNewOrderForCurrAuthUser(selectedTour);
        showAllTours(model);
    }



}
