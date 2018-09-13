package com.paul.repositories;

import com.paul.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Long> {

        @Query(value = "select * from users usr where usr.email=:email", nativeQuery = true)
        Optional<User> findByEmail (@Param("email") String email);
}
