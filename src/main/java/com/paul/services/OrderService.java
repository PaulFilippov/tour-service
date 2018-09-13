package com.paul.services;

import com.paul.entities.Order;
import com.paul.entities.Tour;
import com.paul.entities.User;
import com.paul.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderRepository orderRep;

    UserService userService = new UserService();
    TourService tourService = new TourService();


    public Set<Order> getAllOrder()
    {
        Set<Order> allOrder = new HashSet();
        //cast from Iterable in Set
        orderRep.findAll().iterator().forEachRemaining(allOrder::add);
        return allOrder;
    }

    // создание нового заказанного тура для текущегор авторизованого юзера
    public void createNewOrderForCurrAuthUser(Tour tour) {
        User currUser = userService.getCurAuthUser();
        Order order = new Order(currUser, tour);
        orderRep.save(order);
    }


    public Set<Order> getUserOrders() {
        Set<Order> userOrders = new HashSet();
        //cast from Iterable in Set
        orderRep.findAll().iterator().forEachRemaining(userOrders::add);
        return userOrders;
    }

}
