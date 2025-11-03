package com.example.programming_mobile_device_be.mapper;

import com.example.programming_mobile_device_be.dto.request.playlist.PlaylistCreateRequest;
import com.example.programming_mobile_device_be.dto.response.playlist.PlaylistResponse;
import com.example.programming_mobile_device_be.entity.Playlist;
import com.example.programming_mobile_device_be.entity.User;
import org.springframework.stereotype.Component;

@Component
public class PlaylistMapper {

    public Playlist toEntity(PlaylistCreateRequest request, User user) {
        return Playlist.builder()
                .name(request.getName())
                .description(request.getDescription())
                .user(user)
                .build();
    }

    public PlaylistResponse toResponse(Playlist playlist) {
        return PlaylistResponse.builder()
                .playlistId(playlist.getPlaylistId())
                .name(playlist.getName())
                .description(playlist.getDescription())
                .userId(playlist.getUser() != null ? playlist.getUser().getUserId() : null)
                .username(playlist.getUser() != null ? playlist.getUser().getUsername() : null)
                .build();
    }
}
