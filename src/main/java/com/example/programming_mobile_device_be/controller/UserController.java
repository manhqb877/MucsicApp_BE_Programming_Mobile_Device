package com.example.programming_mobile_device_be.controller;

import com.example.programming_mobile_device_be.dto.request.user.UserCreateRequest;
import com.example.programming_mobile_device_be.dto.response.ApiResponse;
import com.example.programming_mobile_device_be.dto.response.user.UserResponse;
import com.example.programming_mobile_device_be.entity.Role;
import com.example.programming_mobile_device_be.entity.User;
import com.example.programming_mobile_device_be.mapper.UserMapper;
import com.example.programming_mobile_device_be.service.RoleService;
import com.example.programming_mobile_device_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService; // service để load Role từ tên

    @Autowired
    private UserMapper userMapper;

    // ✅ Lấy danh sách toàn bộ User
    @GetMapping
    public ApiResponse<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userService.findAll()
                .stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());

        return ApiResponse.<List<UserResponse>>builder()
                .message("Fetched all users successfully")
                .result(users)
                .build();
    }

    // ✅ Lấy User theo ID
    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUserById(@PathVariable String id) {
        User user = userService.findByUserId(id);
        if (user == null) {
            return ApiResponse.<UserResponse>builder()
                    .code(404)
                    .message("User not found")
                    .build();
        }

        return ApiResponse.<UserResponse>builder()
                .message("Fetched user successfully")
                .result(userMapper.toResponse(user))
                .build();
    }

    // ✅ Tạo mới User
    @PostMapping
    public ApiResponse<UserResponse> createUser(@Valid @RequestBody UserCreateRequest request) {
        // Lấy roles từ tên
        Set<Role> roles = roleService.findByNames(request.getRoles());

        User user = userMapper.toEntity(request, roles);
        userService.upsert(user);

        return ApiResponse.<UserResponse>builder()
                .message("User created successfully")
                .result(userMapper.toResponse(user))
                .build();
    }

    // ✅ Xóa User
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ApiResponse.<Void>builder()
                .message("User deleted successfully")
                .build();
    }
}
