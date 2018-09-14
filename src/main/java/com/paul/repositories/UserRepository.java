package com.paul.repositories;

import com.paul.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import javax.xml.crypto.Data;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

        @Query(value = "SELECT * FROM users usr WHERE usr.email = :email", nativeQuery = true)
        Optional <User> findUserByEmail (@Param("email") String email);

        //@Modifying(clearAutomatically = true)
        @Query(value = "UPDATE User usr SET usr.first_name = :newFirstName, usr.last_name = :newLastName, usr.birthday = :newBirthday  WHERE usr.id_user = :id_user")
        Optional <User> updateUserProfile (@Param("id_user") Long id_user,@Param("newFirstName") String newFirstName, @Param("newLastName") String newLastName, @Param("newBirthday") Data newBirthday);

//        @Query(value = "UPDATE User usr SET usr.last_name = :newLastName WHERE usr.id_user = :id_user")
//        Optional <User> updateUserLastName (@Param("id_user") Long id_user,@Param("newLastName") String newLastName);
//
//        @Query(value = "UPDATE User usr SET usr.birthday = :newBirthday WHERE usr.id_user = :id_user")
//        Optional <User> updateUserBirthday (@Param("id_user") Long id_user,@Param("newBirthday") String newBirthday);

}
