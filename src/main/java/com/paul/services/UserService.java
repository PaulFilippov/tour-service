package com.paul.services;


import com.paul.entities.User;
import com.paul.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;

import javax.transaction.Transactional;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserService implements UserDetailsService {

//    @Autowired
    UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Set<User> getAllUser()
    {
        Set<User> allUser = new HashSet();
        //cast from Iterable in Set
        userRepository.findAll().iterator().forEachRemaining(allUser::add);
        return allUser;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =  userRepository.findUserByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("user with email " + email + " not found"));
        System.out.println("Данные юзера из loadUserByUsername "+ user);
        return user;
    }

    //возвращает email авторизованого юзера (email вводится в поле username в spring sec)
    public String getCurUserEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String emailCurrentAuthUser=auth.getName();
        System.out.println("Емайл текущего авторизованного юзера " + emailCurrentAuthUser);
        return emailCurrentAuthUser;
    }

    public void updateUserPforile (User user){
        userRepository.updateUserProfile(user.getId_user(),
                user.getFirst_name(),
                user.getLast_name(),
                (Data) user.getBirthday());
    }

    //возвращает из базы сущность авторизованного юзера (ищется по email)
    public User getCurAuthUser () throws NullPointerException {
        String emailCurAuthUser = getCurUserEmail();
        System.out.println("1getCurAuthUser "+ emailCurAuthUser);


//        Iterable <User> user = userRepository.findAll();
//       List<User> set = new ArrayList();
//        for (User item: user)
//            set.add(item);

        User user = userRepository.findUserByEmail(emailCurAuthUser)
                    .orElseThrow(() ->
                    new UsernameNotFoundException("user with email " + emailCurAuthUser + " not found"));

        System.out.println("2getCurAuthUser "+ emailCurAuthUser);
        return user;
//        return set.get(2);
    }


}
