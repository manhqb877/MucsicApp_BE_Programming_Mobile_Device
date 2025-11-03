package com.example.programming_mobile_device_be.dto.response.playlist;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaylistResponse {
    private String playlistId;
    private String name;
    private String description;
    private String userId;
    private String username;
}
