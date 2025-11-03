package com.example.programming_mobile_device_be.service.impl;

import com.example.programming_mobile_device_be.entity.User;
import com.example.programming_mobile_device_be.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements com.example.programming_mobile_device_be.service.UserService {
    @Autowired
    private UserRespository userRepository;

    // upsert = insert + update

    @Override
    public void upsert(User user) {

        userRepository.save(user);
    }

    // delete

    @Override
    public void delete(Long id) {

        userRepository.deleteById(id);
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Override
    public User findById(Long id) {
        return userRepository
                .findById(id)
                .orElse(null);
    }

    public User findByUserId(String userId) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

}
