package com.example.programming_mobile_device_be.dto.response.user;

import com.example.programming_mobile_device_be.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private String userId;
    private String username;
    private String email;
    private Gender gender;
    private LocalDateTime createdAt;
    private Set<String> roles;

    List<PlaylistResponse> playlists;
    List<CommentReponse> comments;
}
