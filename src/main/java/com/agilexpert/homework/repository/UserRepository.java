package com.agilexpert.homework.repository;


import com.agilexpert.homework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByUsername(String username);

    @Transactional
    public void deleteByUsername(String username);
}
