package com.agilexpert.homework.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Icon {

    @GeneratedValue
    @Id
    private Long id;

    @ToString.Exclude
    @OneToOne(mappedBy = "icon")
    Application application;
}
