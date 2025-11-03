package com.example.programming_mobile_device_be.mapper;

import com.example.programming_mobile_device_be.dto.request.artist.ArtistCreateRequest;
import com.example.programming_mobile_device_be.dto.request.artist.ArtistUpdateRequest;
import com.example.programming_mobile_device_be.dto.response.artist.ArtistResponse;
import com.example.programming_mobile_device_be.entity.Artist;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapper {

    public Artist toEntity(ArtistCreateRequest request) {
        Artist artist = new Artist();
        artist.setName(request.getName());
        artist.setCountry(request.getCountry());
        artist.setDescription(request.getDescription());
        return artist;
    }

    public void updateEntity(Artist artist, ArtistUpdateRequest request) {
        if (request.getName() != null)
            artist.setName(request.getName());
        if (request.getCountry() != null)
            artist.setCountry(request.getCountry());
        if (request.getDescription() != null)
            artist.setDescription(request.getDescription());
    }

    public ArtistResponse toResponse(Artist artist) {
        return ArtistResponse.builder()
                .id(artist.getId())
                .name(artist.getName())
                .country(artist.getCountry())
                .description(artist.getDescription())
                .build();
    }
}
