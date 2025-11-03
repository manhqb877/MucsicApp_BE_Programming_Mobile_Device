package com.example.programming_mobile_device_be.dto.request.song;

import lombok.Data;

@Data
public class SongUpdateRequest {

    private String songTitle;
    private String duration;
}
