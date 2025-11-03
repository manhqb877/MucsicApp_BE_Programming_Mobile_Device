package com.example.programming_mobile_device_be.dto.request.artist;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistCreateRequest {
    @NotBlank
    private String name;

    private String country;
    private String description;
}
