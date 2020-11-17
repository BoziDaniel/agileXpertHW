package com.agilexpert.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private boolean isRunning;

    public void startApplication() {
        setRunning(true);
        System.out.println(String.format("%s is running", this.name));
    }

    public void stopApplication() {
        setRunning(false);
        System.out.println(String.format("%s stops", this.name));
    }
}
