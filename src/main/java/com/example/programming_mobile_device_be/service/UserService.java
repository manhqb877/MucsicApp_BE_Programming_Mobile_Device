package com.example.programming_mobile_device_be.service;

import com.example.programming_mobile_device_be.entity.User;

import java.util.List;

public interface UserService {
    void upsert(User user);

    void delete(Long id);

    List<User> findAll();
    User findByUserId(String userId);
    User findById(Long id);
}
