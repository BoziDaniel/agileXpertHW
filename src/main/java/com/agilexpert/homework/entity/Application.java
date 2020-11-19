package com.agilexpert.homework.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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

    private boolean isRunning = false;

    @ManyToMany(mappedBy = "applications", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private List<User> users = new ArrayList<>();

    @OneToOne
    Icon icon;

    public void startApplication() {
        setRunning(true);
        System.out.println(String.format("%s is running", this.name));
    }

    public void stopApplication() {
        setRunning(false);
        System.out.println(String.format("%s stops", this.name));
    }

}
