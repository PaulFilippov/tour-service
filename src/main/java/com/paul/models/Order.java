package com.paul.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Tour tour;
    private boolean confirmed;
    @ManyToMany
    Set<User> users;

    public Order() {
    }

    public Order(User user, Tour tour) {
        this.users = new HashSet<>();
        this.users.add(user);
        this.tour = tour;
        user.orders.add(this);
        tour.orders.add(this);
    }



}
