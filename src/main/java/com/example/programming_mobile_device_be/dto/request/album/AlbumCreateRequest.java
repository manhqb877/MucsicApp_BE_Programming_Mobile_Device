package com.example.programming_mobile_device_be.dto.request.album;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AlbumCreateRequest {
    @NotBlank
    private String title;

    @NotNull
    private LocalDateTime releaseDate;

    @NotBlank
    private Long artistId;
}
