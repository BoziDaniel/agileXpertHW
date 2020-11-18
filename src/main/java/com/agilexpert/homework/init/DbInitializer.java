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
        User father = User.builder()
                .username("father")
                .email("father@gmail.com")
                .build();
        userRepository.save(father);
        Application gpsApp = Application.builder().name("gpsApp").build();
        Application gameApp1 = Application.builder().name("gameApp1").build();
        Application gameApp2 = Application.builder().name("gameApp2").build();
        Application recipeApp= Application.builder().name("recipeApp").build();
        applicationRepository.save(gpsApp);
        applicationRepository.save(gameApp1);
        applicationRepository.save(gameApp2);
        applicationRepository.save(recipeApp);

    }
}
