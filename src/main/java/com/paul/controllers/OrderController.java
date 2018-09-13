package com.paul.controllers;

import com.paul.entities.Order;
import com.paul.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/orders")
    public String showUserOrders(ModelMap model) {
        Set<Order> userOrders = orderService.getUserOrders();
        model.addAttribute("userOrders", userOrders);
        System.out.println("Все туры: "+orderService.getAllOrder()+"/n");
        return "orders";
    }

}
