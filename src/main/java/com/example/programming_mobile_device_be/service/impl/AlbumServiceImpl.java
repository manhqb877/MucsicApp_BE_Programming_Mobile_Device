package com.example.programming_mobile_device_be.service.impl;

import com.example.programming_mobile_device_be.entity.Album;
import com.example.programming_mobile_device_be.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements com.example.programming_mobile_device_be.service.AlbumService {
    @Autowired
    private  AlbumRepository albumRepository;

    @Override
    public List<Album> getAllAlbums() { return albumRepository.findAll(); }

    @Override
    public Optional<Album> getAlbumById(Long id) { return albumRepository.findById(id); }

    @Override
    public Album saveAlbum(Album album) { return albumRepository.save(album); }

    @Override
    public void deleteAlbum(Long id) { albumRepository.deleteById(id); }

    @Override
    public List<Album> searchByTitle(String title) {
        return albumRepository.findByTitleContainingIgnoreCase(title);
    }
}
