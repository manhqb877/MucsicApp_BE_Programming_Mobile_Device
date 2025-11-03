package com.example.programming_mobile_device_be.service.impl;

import com.example.programming_mobile_device_be.entity.Role;
import com.example.programming_mobile_device_be.enums.RoleName;
import com.example.programming_mobile_device_be.repository.RoleRepository;
import com.example.programming_mobile_device_be.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Set<Role> findByNames(Set<String> names) {
        // Chuyển Set<String> → Set<RoleName>
        Set<RoleName> roleNames = names.stream()
                .map(name -> RoleName.valueOf(name.toUpperCase()))
                .collect(Collectors.toSet());

        // Trả về Set<Role>
        return roleRepository.findByNameIn(roleNames);
    }

    @Override
    public Set<Role> findByNameIn(Set<RoleName> names) {
        return Set.of();
    }

    //them tao user có roles

}
