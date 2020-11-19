package com.agilexpert.homework;

import com.agilexpert.homework.simulation.Simulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class AgileXpertHwApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgileXpertHwApplication.class, args);
    }

    @Autowired
    Simulation simulation;
    @Bean
    @Profile("dev")
    public CommandLineRunner init() {
        return args -> {
            simulation.runSimulation();
        };
    }
}
