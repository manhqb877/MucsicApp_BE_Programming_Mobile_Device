package com.example.programming_mobile_device_be.dto.request.artist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistUpdateRequest {
    private String name;
    private String country;
    private String description;
}
