package com.example.programming_mobile_device_be.dto.request.user;

import com.example.programming_mobile_device_be.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateRequest {

    @NotBlank(message = "Username is required")
    String username;

    @Email(message = "Invalid email format")
    String email;

    @NotBlank(message = "Password is required")
    String password;

    Gender gender;

    Set<String> roles; // tên role (VD: ["ROLE_USER", "ROLE_ADMIN"])
}
