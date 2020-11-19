package com.agilexpert.homework.repository;

import com.agilexpert.homework.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Application findByAppName(String appName);
}

