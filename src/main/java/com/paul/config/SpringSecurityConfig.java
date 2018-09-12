package com.paul.config;

import com.paul.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /*Метод configure(HttpSecurity) определяет, какие URL пути должны быть защищены, а какие нет.
    В частности, "/" и "/home" настроены без требования к авторизации.
    Ко всем остальным путям должна быть произведена аутентификация.*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                //.loginPage().permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
                //.logout().clearAuthentication(true);  //logout configuration

    }

        @Autowired
        public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
            .withUser("user1")
                    .password("1")
                    .roles("USER")
                    .and()
                    .withUser("user2")
                    .password("1")
                    .roles("USER");
        }


//        /*init () Cоздает в памяти хранилище пользователей с единственным пользователем.
//        Этому пользователю дано имя "user", пароль "password" и роль "ROLE".*/
//    @Configuration
//    protected static class AuthenticationConfiguration extends
//            GlobalAuthenticationConfigurerAdapter {
//
//        /*init () Cоздает в памяти хранилище пользователей с единственным пользователем.
//        Этому пользователю дано имя "user", пароль "password" и роль "ROLE".*/
//
//        @Override
//        public void init(AuthenticationManagerBuilder auth) throws Exception {
//            auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
//                    .withUser("user1")
//                    .password("1")
//                    .roles("USER")
//                    .and()
//                    .withUser("user2")
//                    .password("1")
//                    .roles("USER");
//        }
//    }
}