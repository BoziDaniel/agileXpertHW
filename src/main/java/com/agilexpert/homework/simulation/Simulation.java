package com.agilexpert.homework.simulation;

import com.agilexpert.homework.init.DbInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Simulation {
    @Autowired
    DbInitializer dbInitializer;
    public void runSimulation() {
        dbInitializer.intializeDatabase();
    }
}
