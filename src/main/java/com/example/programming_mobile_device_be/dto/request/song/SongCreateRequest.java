package com.example.programming_mobile_device_be.dto.request.song;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SongCreateRequest {

    @NotBlank
    private String songTitle;

    private String duration;

    @NotNull
    private Long albumId; // ID của album chứa bài hát
}
