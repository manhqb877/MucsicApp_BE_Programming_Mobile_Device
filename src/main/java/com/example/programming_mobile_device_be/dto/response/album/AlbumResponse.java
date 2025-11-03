package com.example.programming_mobile_device_be.dto.response.album;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class AlbumResponse {
    private String albumId;
    private String title;
    private LocalDateTime releaseDate;
    private String artistId;
    private String artistName;
}
