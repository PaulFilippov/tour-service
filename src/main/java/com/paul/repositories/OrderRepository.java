package com.paul.repositories;

import com.paul.entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(value = "SELECT * FROM orders ordr WHERE ordr.id_user = :id_user", nativeQuery = true)
    Optional <Order> findAllUserOrders(@Param("id_user") Long id_user);

//    @Query(value = "DELETE * FROM orders ordr WHERE ordr.id_order = :id_order ", nativeQuery = true)
//    Optional <Order> deleteUserOrder(@Param("id_order") Long id_order);
}