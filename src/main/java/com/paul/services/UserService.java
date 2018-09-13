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

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    public Set<User> getAllUser()
    {
        Set<User> allUser = new HashSet();
        //cast from Iterable in Set
        userRepository.findAll().iterator().forEachRemaining(allUser::add);
        return allUser;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =  userRepository.findByEmail(email).orElseThrow(() ->
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

    //возвращает из базы сущность авторизованного юзера (ищется по email)
    public User getCurAuthUser () throws NullPointerException {
        String emailCurAuthUser = getCurUserEmail();
        System.out.println("1getCurAuthUser "+ emailCurAuthUser);
       // try {
            //User user = userRepository.findByEmail(emailCurAuthUser).get();
        User user = userRepository.findByEmail("myemail").get();
//                    .orElseThrow(() ->
//                    new UsernameNotFoundException("user with email " + emailCurAuthUser + " not found"));
        //} catch (NullPointerException ex){
           // System.out.println("Ошибка "+ex);
        //}
        System.out.println("2getCurAuthUser "+ emailCurAuthUser);
        return user;
    }


}
