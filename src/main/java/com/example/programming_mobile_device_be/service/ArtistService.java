package com.example.programming_mobile_device_be.service;

import com.example.programming_mobile_device_be.entity.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> findAll();

    Artist findById(Long id);

    List<Artist> findByNameContainingIgnoreCase(String name);

    Artist save(Artist artist);

    void deleteById(Long id);
}
