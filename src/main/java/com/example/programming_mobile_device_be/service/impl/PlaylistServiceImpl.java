package com.example.programming_mobile_device_be.service.impl;

import com.example.programming_mobile_device_be.entity.Playlist;
import com.example.programming_mobile_device_be.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements com.example.programming_mobile_device_be.service.PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    // Tìm playlist theo ID
    @Override
    public Playlist getPlaylistById(Long id) {
        return playlistRepository.findById(id)
                .orElse(null);
    }

    // Thêm hoặc cập nhật playlist
    @Override
    public Playlist savePlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    // Xóa playlist
    @Override
    public void deletePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }

    // Tìm kiếm theo tên
    @Override
    public List<Playlist> searchByName(String name) {
        return playlistRepository.findByNameContainingIgnoreCase(name);
    }
}
