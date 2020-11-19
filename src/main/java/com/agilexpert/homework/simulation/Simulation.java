package com.agilexpert.homework.simulation;

import com.agilexpert.homework.entity.User;
import com.agilexpert.homework.init.DbInitializer;
import com.agilexpert.homework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Simulation {
    @Autowired
    DbInitializer dbInitializer;
    @Autowired
    UserRepository userRepository;

    public void runSimulation() {
        dbInitializer.intializeDatabase();
        registerUser("son");
    }

    public void registerUser(String username) {
        if (userRepository.findUserByUsername(username) == null) {
            User newUser = User.builder().username(username).build();
            userRepository.save(newUser);
            System.out.println(String.format("user registered with username: %s", username));
        } else {
            System.out.println("username already in use");
        }
    }


    }
