package com.paul.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id_order;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tour")
    private Tour tour;
    private boolean confirmed;
    @ManyToMany(mappedBy = "userOrders")
    Set<User> usersOfOrder;

    public Order() {
    }

    public Order(User user, Tour tour) {
        this.usersOfOrder = new HashSet<>();
        this.usersOfOrder.add(user);
        this.tour = tour;
        user.userOrders.add(this);
        tour.ordersOfTour.add(this);
    }

    public Long getId_order() {
        return id_order;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id_order=" + id_order +
                ", tour=" + tour +
                ", confirmed=" + confirmed +
                ", usersOfOrder=" + usersOfOrder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id_order, order.id_order);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_order);
    }
}
