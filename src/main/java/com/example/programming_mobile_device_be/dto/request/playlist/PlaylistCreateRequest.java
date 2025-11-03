package com.example.programming_mobile_device_be.dto.request.playlist;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlaylistCreateRequest {

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private String userId; // ID của user tạo playlist
}
