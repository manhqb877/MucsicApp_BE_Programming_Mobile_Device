package com.example.programming_mobile_device_be.dto.response.artist;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ArtistResponse {
    private Long id;
    private String name;
    private String country;
    private String description;
}
