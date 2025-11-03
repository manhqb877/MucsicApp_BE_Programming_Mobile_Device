package com.example.programming_mobile_device_be.dto.request.playlist;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PlaylistUpdateRequest {

    @NotBlank
    private String name;

    private String description;
}
