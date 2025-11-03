package com.example.programming_mobile_device_be.dto.request.user;

import com.example.programming_mobile_device_be.enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String username;
    String email;
    String password;
    Gender gender;
    Set<String> roles;
}
