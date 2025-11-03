package com.example.programming_mobile_device_be.repository;

import com.example.programming_mobile_device_be.entity.Role;
import com.example.programming_mobile_device_be.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {
    // Tìm 1 Role duy nhất theo tên
    Optional<Role> findByName(RoleName name);

    // Tìm nhiều Role theo danh sách RoleName
    Set<Role> findByNameIn(Set<RoleName> names);
}
