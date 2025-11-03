package com.example.programming_mobile_device_be.repository;


import com.example.programming_mobile_device_be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRespository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String name);
}
