package com.agilexpert.homework.init;

import com.agilexpert.homework.entity.Application;
import com.agilexpert.homework.entity.User;
import com.agilexpert.homework.repository.ApplicationRepository;
import com.agilexpert.homework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer {
    private UserRepository userRepository;
    private ApplicationRepository applicationRepository;
    @Autowired
    public DbInitializer(UserRepository userRepository, ApplicationRepository applicationRepository) {
        this.userRepository = userRepository;
        this.applicationRepository = applicationRepository;
    }
    public void intializeDatabase() {

        Application gpsApp = Application.builder().name("gpsApp").build();
        Application gameApp1 = Application.builder().name("gameApp1").build();
        Application gameApp2 = Application.builder().name("gameApp2").build();
        Application recipeApp= Application.builder().name("recipeApp").build();
        applicationRepository.save(gpsApp);
        applicationRepository.save(gameApp1);
        applicationRepository.save(gameApp2);
        applicationRepository.save(recipeApp);
        User father = User.builder()
                .username("father")
                .email("father@gmail.com")
                .application(gpsApp)
                .application(gameApp1)
                .build();
        User mother = User.builder()
                .username("mother")
                .email("mother@gmail.com")
                .application(recipeApp)
                .build();
        User kid1 = User.builder()
                .username("kid1")
                .email("kid1@gmail.com")
                .application(gameApp1)
                .build();
        User kid2 = User.builder()
                .username("kid2")
                .email("kid2@gmail.com")
                .application(gameApp1)
                .application(gameApp2)
                .build();
        userRepository.save(father);
        userRepository.save(mother);
        userRepository.save(kid1);
        userRepository.save(kid2);
        System.out.println(father);
        System.out.println(mother);
    }
}
