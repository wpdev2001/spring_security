package com.security.wp.SpringSecurityCode;

import com.security.wp.SpringSecurityCode.Repository.UserRepository;
import com.security.wp.SpringSecurityCode.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User user = userRepository.findByUsername("Piyush").orElse(null);
        if(user == null){
            user = new User();
            user.setUserId(UUID.randomUUID().toString());
            user.setUsername("Piyush");
            user.setPassword(passwordEncoder.encode("password"));
            user.setRole("USER");
            userRepository.save(user);
            System.out.println("User saved: " + user.getUsername());
        }
    }
}
