package com.example.programming_mobile_device_be.mapper;

import com.example.programming_mobile_device_be.dto.request.album.AlbumCreateRequest;
import com.example.programming_mobile_device_be.dto.response.album.AlbumResponse;
import com.example.programming_mobile_device_be.entity.Album;
import com.example.programming_mobile_device_be.entity.Artist;
import org.springframework.stereotype.Component;

@Component
public class AlbumMapper {
    public Album toEntity(AlbumCreateRequest req, Artist artist) {
        return Album.builder()
                .title(req.getTitle())
                .releaseDate(req.getReleaseDate())
                .artist(artist)
                .build();
    }

    public AlbumResponse toResponse(Album album) {
        return AlbumResponse.builder()
                .albumId(album.getAlbumId())
                .title(album.getTitle())
                .releaseDate(album.getReleaseDate())
                .artistId(album.getArtist() != null ? album.getArtist().getArtistId() : null)
                .artistName(album.getArtist() != null ? album.getArtist().getArtistName() : null)
                .build();
    }
}
