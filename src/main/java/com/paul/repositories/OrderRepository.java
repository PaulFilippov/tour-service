package com.paul.repositories;

import com.paul.entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(value = "select * from orders ordr where ordr.id_user= :id_user", nativeQuery = true)
    Optional<Order> findAllUserOrders(@Param("id_user") Long id_user);

}