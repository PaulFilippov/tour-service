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
    private UserService userService; //= new UserService();
//    private OrderRepository orderRepository;

    public DataLoader(UserRepository userRepository, TourRepository tourRepository) {
        this.userRepository = userRepository;
        this.tourRepository = tourRepository;
//        this.orderRepository = orderRepository;
    }

    public void run(ApplicationArguments args) {

        Date dateBirth = new Date();

        for (int i = 1; i < 10; i++) {

            Calendar cb = Calendar.getInstance();
            cb.setTime(dateBirth);
            cb.add(Calendar.DATE, 10);
            dateBirth=cb.getTime();

            User temp = new User(
                    "name" + Integer.toString(i),
                    "last_name",
                    "email"+ Integer.toString(i),
                    "pass"+ Integer.toString(i),
                    true,
                    dateBirth,
                    UserRole.USER
            );
            userRepository.save(temp);
        }

        //System.out.println("из лоадера "+userService.getAllUser());

        Date dt_start = new Date();
        Date dt_end = new Date();

        for (int i = 1; i < 10; i++) {

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



    }

}
