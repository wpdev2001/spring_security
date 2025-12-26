package com.security.wp.SpringSecurityCode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService uerDetailsService() {
        //creating users
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("piyush")
                .password("piyush123")
                .roles("USER", "ADMIN").build();

        UserDetails user2 = User.withDefaultPasswordEncoder() // password encoder is used to encode the password
                .username("shreyash")
                .password("shreyash123")
                .roles("USER", "ADMIN").build();

        //this is used for creating a user details service that stores user details in memory
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1, user2);
        return inMemoryUserDetailsManager;
    }
}
