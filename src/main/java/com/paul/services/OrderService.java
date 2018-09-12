package com.paul.services;

import com.paul.entities.Order;
import com.paul.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRep;

    public Set<Order> getUserOrders()
    {
        Set<Order> userOrders = new HashSet();
        //cast from Iterable in Set
        orderRep.findAll().iterator().forEachRemaining(userOrders::add);
        return userOrders;
    }

}
