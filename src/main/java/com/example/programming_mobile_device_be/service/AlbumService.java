package com.example.programming_mobile_device_be.service;

import com.example.programming_mobile_device_be.entity.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<Album> getAllAlbums();

    Optional<Album> getAlbumById(Long id);

    Album saveAlbum(Album album);

    void deleteAlbum(Long id);

    List<Album> searchByTitle(String title);
}
