package com.example.programming_mobile_device_be.service;

import com.example.programming_mobile_device_be.entity.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> getAllSongs();

    Optional<Song> getSongById(Long id);

    Song saveSong(Song song);

    void deleteSong(Long id);

    List<Song> searchByTitle(String title);
}
