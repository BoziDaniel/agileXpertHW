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
public class User {

    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Singular
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Application> applications = new ArrayList<>();

    public void addNewApplication(Application application) {
        if (!applications.contains(application)) {
            applications.add(application);
        }
    }
}
