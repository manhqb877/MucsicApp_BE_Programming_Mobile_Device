package com.example.programming_mobile_device_be.controller;

import com.example.programming_mobile_device_be.dto.request.playlist.PlaylistCreateRequest;
import com.example.programming_mobile_device_be.dto.request.playlist.PlaylistUpdateRequest;
import com.example.programming_mobile_device_be.dto.response.ApiResponse;
import com.example.programming_mobile_device_be.dto.response.playlist.PlaylistResponse;
import com.example.programming_mobile_device_be.entity.Playlist;
import com.example.programming_mobile_device_be.entity.User;
import com.example.programming_mobile_device_be.mapper.PlaylistMapper;
import com.example.programming_mobile_device_be.service.PlaylistService;
import com.example.programming_mobile_device_be.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/playlists")
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;
    private final PlaylistMapper playlistMapper;
    private final UserService userService; // dùng để gán user cho playlist

    // ✅ Lấy tất cả playlist
    @GetMapping
    public ApiResponse<List<PlaylistResponse>> getAllPlaylists() {
        List<PlaylistResponse> responses = playlistService.getAllPlaylists()
                .stream()
                .map(playlistMapper::toResponse)
                .collect(Collectors.toList());

        return ApiResponse.<List<PlaylistResponse>>builder()
                .message("Fetched all playlists successfully")
                .result(responses)
                .build();
    }

    // ✅ Lấy playlist theo ID
    @GetMapping("/{id}")
    public ApiResponse<PlaylistResponse> getPlaylistById(@PathVariable Long id) {
        Playlist playlist = playlistService.getPlaylistById(id);

        if (playlist == null) {
            return ApiResponse.<PlaylistResponse>builder()
                    .code(404)
                    .message("Playlist not found")
                    .build();
        }

        return ApiResponse.<PlaylistResponse>builder()
                .message("Fetched playlist successfully")
                .result(playlistMapper.toResponse(playlist))
                .build();
    }

    // ✅ Tạo mới playlist
    @PostMapping
    public ApiResponse<PlaylistResponse> createPlaylist(@Valid @RequestBody PlaylistCreateRequest request) {
        User user = userService.findByUserId(request.getUserId());
        if (user == null) {
            return ApiResponse.<PlaylistResponse>builder()
                    .code(404)
                    .message("User not found for playlist")
                    .build();
        }

        Playlist playlist = playlistMapper.toEntity(request, user);
        playlistService.savePlaylist(playlist);

        return ApiResponse.<PlaylistResponse>builder()
                .message("Playlist created successfully")
                .result(playlistMapper.toResponse(playlist))
                .build();
    }

    // ✅ Cập nhật playlist
    @PutMapping("/{id}")
    public ApiResponse<PlaylistResponse> updatePlaylist(@PathVariable Long id,
                                                        @Valid @RequestBody PlaylistUpdateRequest request) {
        Playlist playlist = playlistService.getPlaylistById(id);

        if (playlist == null) {
            return ApiResponse.<PlaylistResponse>builder()
                    .code(404)
                    .message("Playlist not found")
                    .build();
        }

        playlist.setName(request.getName());
        playlist.setDescription(request.getDescription());

        playlistService.savePlaylist(playlist);

        return ApiResponse.<PlaylistResponse>builder()
                .message("Playlist updated successfully")
                .result(playlistMapper.toResponse(playlist))
                .build();
    }

    // ✅ Xóa playlist
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
        return ApiResponse.<Void>builder()
                .message("Playlist deleted successfully")
                .build();
    }

    // ✅ Tìm kiếm playlist theo tên
    @GetMapping("/search")
    public ApiResponse<List<PlaylistResponse>> searchPlaylists(@RequestParam("name") String name) {
        List<PlaylistResponse> results = playlistService.searchByName(name)
                .stream()
                .map(playlistMapper::toResponse)
                .collect(Collectors.toList());

        return ApiResponse.<List<PlaylistResponse>>builder()
                .message("Search completed successfully")
                .result(results)
                .build();
    }
}
