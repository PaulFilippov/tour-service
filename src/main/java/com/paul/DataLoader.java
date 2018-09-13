package com.paul;

import com.paul.entities.Tour;
import com.paul.entities.User;
import com.paul.entities.UserRole;
import com.paul.repositories.TourRepository;
import com.paul.repositories.UserRepository;
import com.paul.services.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;
    private TourRepository tourRepository;
    private UserService userService = new UserService();
//    private OrderRepository orderRepository;

    public DataLoader(UserRepository userRepository, TourRepository tourRepository) {
        this.userRepository = userRepository;
        this.tourRepository = tourRepository;
//        this.orderRepository = orderRepository;
    }

    public void run(ApplicationArguments args) {

        // int[] a = new int[] {0, 1, 2, 3,4};

        for (int i = 10; i < 10 + 10; i++) {

            if (i == 11) {

                User temp = new User(
                        "admin",
                        "admin",
                        "myemail",
                        "admin",
                        true,
                        10L,
                        UserRole.USER
                );
                userRepository.save(temp);
                continue;
            }

            User temp = new User(
                    "name" + Integer.toString(i),
                    "last_name",
                    "email"+ Integer.toString(i),
                    "password",
                    true,
                    10L,
                    UserRole.USER
            );
            userRepository.save(temp);
        }

        Date dt_start = new Date();
        Date dt_end = new Date();

        for (int i = 10; i < 10 + 10; i++) {

            Calendar c = Calendar.getInstance();
            c.setTime(dt_start);
            c.add(Calendar.MONTH, 1);
            dt_start = c.getTime();
            c.add(Calendar.DATE, 10);
            dt_end=c.getTime();



            Tour temp_order = new Tour(
                    "name" + Integer.toString(i),
                    "descrition" + Integer.toString(i),
                    "location" + Integer.toString(i),
                    dt_start,
                    dt_end,
                    20
            );
            tourRepository.save(temp_order);
        }

       /* for (int i = 10000; i < 10000 + 200; i++) {
            Tour temp = new Tour("name" + Integer.toString(i));
            tourRepository.save(temp);
        }*/

/*        for (int i = 10000; i < 10000 + 200; i++) {
            Order temp = new Order("n29");
            orderRepository.save(temp);
        }
        System.out.println("HELLO from run");*/
    }

}
