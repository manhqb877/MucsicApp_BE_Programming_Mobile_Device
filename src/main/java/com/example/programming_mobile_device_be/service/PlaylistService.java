package com.example.programming_mobile_device_be.service;

import com.example.programming_mobile_device_be.entity.Playlist;

import java.util.List;

public interface PlaylistService {
    List<Playlist> getAllPlaylists();

    // Tìm playlist theo ID
    Playlist getPlaylistById(Long id);

    // Thêm hoặc cập nhật playlist
    Playlist savePlaylist(Playlist playlist);

    // Xóa playlist
    void deletePlaylist(Long id);

    // Tìm kiếm theo tên
    List<Playlist> searchByName(String name);
}
