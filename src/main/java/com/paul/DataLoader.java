package com.paul;

import com.paul.models.Tour;
import com.paul.models.User;
import com.paul.repositories.TourRepository;
import com.paul.repositories.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;
    private TourRepository tourRepository;
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
                        "email",
                        "admin",
                        true,
                        10L
                );
                userRepository.save(temp);
                continue;
            }

            User temp = new User(
                    "name" + Integer.toString(i),
                    "last_name",
                    "email",
                    "password",
                    true,
                    10L
            );
            userRepository.save(temp);
        }

        for (int i = 10; i < 10 + 10; i++) {
            Tour temp_order = new Tour(
                    "name" + Integer.toString(i),
                    "descrition" + Integer.toString(i),
                    "location" + Integer.toString(i),
                    200L,
                    200L,
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
