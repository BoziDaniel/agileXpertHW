package com.agilexpert.homework.simulation;

import com.agilexpert.homework.entity.Application;
import com.agilexpert.homework.entity.User;
import com.agilexpert.homework.init.DbInitializer;
import com.agilexpert.homework.repository.ApplicationRepository;
import com.agilexpert.homework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Simulation {
    @Autowired
    DbInitializer dbInitializer;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ApplicationRepository applicationRepository;

    public void runSimulation() {
        dbInitializer.intializeDatabase();
        registerUser("son");
        deleteUser("son");
        registerUser("brother");
        addApplicationToUser("brother", "gpsApp");
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

    public void deleteUser(String username) {
        if (userRepository.findUserByUsername(username) != null) {
            userRepository.deleteByUsername(username);
            System.out.println(String.format("user deleted with username: %s", username));
        } else {
            System.out.println("user not found");
        }
    }

    public void addApplicationToUser(String username, String appName) {
        if (userRepository.findUserByUsername(username) != null && applicationRepository.findByAppName(appName) != null) {
            User user = userRepository.findUserByUsername(username);
            System.out.println(String.format("initial user: %s", user.toString()));
            Application application = applicationRepository.findByAppName(appName);
            user.addNewApplication(application);
            userRepository.save(user);
            System.out.println(String.format("user modified, user is now: %s", user.toString()));
        }

    }
}
