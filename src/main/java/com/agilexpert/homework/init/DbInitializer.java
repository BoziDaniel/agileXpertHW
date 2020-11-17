package com.agilexpert.homework.init;

import com.agilexpert.homework.entity.User;
import com.agilexpert.homework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer {
    private UserRepository userRepository;

    @Autowired
    public DbInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void intializeDatabase() {
        User father = User.builder()
                .username("father")
                .email("father@gmail.com")
                .build();
        userRepository.save(father);
    }
}
