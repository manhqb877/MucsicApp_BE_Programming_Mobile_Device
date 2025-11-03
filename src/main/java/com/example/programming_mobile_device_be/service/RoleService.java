package com.example.programming_mobile_device_be.service;

import com.example.programming_mobile_device_be.entity.Role;
import com.example.programming_mobile_device_be.enums.RoleName;

import java.util.Set;

public interface RoleService {
    Set<Role> findByNames(Set<String> roleNames);
    Set<Role> findByNameIn(Set<RoleName> names);
}
