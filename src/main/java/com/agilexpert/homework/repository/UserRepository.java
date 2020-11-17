package com.agilexpert.homework.repository;


import com.agilexpert.homework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
