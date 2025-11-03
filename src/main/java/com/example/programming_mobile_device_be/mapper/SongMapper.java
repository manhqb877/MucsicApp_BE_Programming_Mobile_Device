package com.example.programming_mobile_device_be.mapper;

import com.example.programming_mobile_device_be.dto.request.song.SongCreateRequest;
import com.example.programming_mobile_device_be.dto.response.song.SongResponse;
import com.example.programming_mobile_device_be.entity.Album;
import com.example.programming_mobile_device_be.entity.Song;
import org.springframework.stereotype.Component;

@Component
public class SongMapper {

    public Song toEntity(SongCreateRequest request, Album album) {
        return Song.builder()
                .songTitle(request.getSongTitle())
                .duration(request.getDuration())
                .album(album)
                .build();
    }

    public SongResponse toResponse(Song song) {
        return SongResponse.builder()
                .songId(song.getSongId())
                .songTitle(song.getSongTitle())
                .duration(song.getDuration())
                .albumId(song.getAlbum() != null ? song.getAlbum().getAlbumId() : null)
                .albumTitle(song.getAlbum() != null ? song.getAlbum().getTitle() : null)
                .build();
    }
}
