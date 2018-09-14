package com.paul.controllers;

import com.paul.entities.Order;
import com.paul.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@Controller
public class OrderController {

//    //@Autowired
   OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/orders")
    public String showUserOrders(ModelMap model) {
        Set<Order> userOrders = orderService.getUserOrders();
        model.addAttribute("userOrders", userOrders);
        return "orders";
    }

    @GetMapping (value = "/deleteOrder/{id_order}")
    public String deleteOrder (@PathVariable("id_order") Long id_order, ModelMap model) {
        orderService.deleteUserOrder(id_order);
        //showUserOrders(model);
        return "orders";
    }
}
