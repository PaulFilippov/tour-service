package com.paul.controllers;

import com.paul.models.Order;
import com.paul.models.Tour;
import com.paul.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/orders")
    public String showUserOrders(ModelMap model) {
        Set<Order> userOrders = orderService.getUserOrders();
        model.addAttribute("userOrders", userOrders);
        return "/orders";
    }

}
