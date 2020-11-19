package com.agilexpert.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToOne(mappedBy = "icon")
    Application application;
}
