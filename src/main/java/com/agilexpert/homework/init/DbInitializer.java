package com.agilexpert.homework.init;

import com.agilexpert.homework.entity.Application;
import com.agilexpert.homework.entity.Icon;
import com.agilexpert.homework.entity.User;
import com.agilexpert.homework.repository.ApplicationRepository;
import com.agilexpert.homework.repository.IconRepository;
import com.agilexpert.homework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer {
    private UserRepository userRepository;
    private ApplicationRepository applicationRepository;
    private IconRepository iconRepository;

    @Autowired
    public DbInitializer(UserRepository userRepository, ApplicationRepository applicationRepository, IconRepository iconRepository) {
        this.userRepository = userRepository;
        this.applicationRepository = applicationRepository;
        this.iconRepository = iconRepository;
    }

    public void intializeDatabase() {
        Icon gpsIcon = Icon.builder().build();
        Icon game1Icon = Icon.builder().build();
        Icon game2Icon = Icon.builder().build();
        Icon recipeIcon = Icon.builder().build();

        iconRepository.save(gpsIcon);
        iconRepository.save(game1Icon);
        iconRepository.save(game2Icon);
        iconRepository.save(recipeIcon);

        Application gpsApp = Application.builder()
                .name("gpsApp")
                .icon(gpsIcon)
                .build();
        Application gameApp1 = Application.builder()
                .name("gameApp1")
                .icon(game1Icon)
                .build();
        Application gameApp2 = Application.builder()
                .name("gameApp2")
                .icon(game2Icon)
                .build();
        Application recipeApp = Application.builder()
                .name("recipeApp")
                .icon(recipeIcon)
                .build();

        applicationRepository.save(gpsApp);
        applicationRepository.save(gameApp1);
        applicationRepository.save(gameApp2);
        applicationRepository.save(recipeApp);
        User father = User.builder()
                .username("father")
                .application(gpsApp)
                .application(gameApp1)
                .build();
        User mother = User.builder()
                .username("mother")
                .application(recipeApp)
                .build();
        User kid1 = User.builder()
                .username("kid1")
                .application(gameApp1)
                .build();
        User kid2 = User.builder()
                .username("kid2")
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
