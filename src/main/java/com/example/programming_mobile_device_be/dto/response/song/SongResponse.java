package com.example.programming_mobile_device_be.dto.response.song;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SongResponse {
    private String songId;
    private String songTitle;
    private String duration;
    private String albumId;
    private String albumTitle;
}
