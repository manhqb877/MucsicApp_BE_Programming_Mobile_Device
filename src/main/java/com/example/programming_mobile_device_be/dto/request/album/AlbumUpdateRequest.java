package com.example.programming_mobile_device_be.dto.request.album;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AlbumUpdateRequest {
    @NotBlank
    private String title;
    private LocalDateTime releaseDate;
}
