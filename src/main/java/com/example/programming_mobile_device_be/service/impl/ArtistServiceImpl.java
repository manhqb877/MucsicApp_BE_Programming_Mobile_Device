package com.example.programming_mobile_device_be.service.impl;

import com.example.programming_mobile_device_be.entity.Artist;
import com.example.programming_mobile_device_be.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements com.example.programming_mobile_device_be.service.ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }

    @Override
    public List<Artist> findByNameContainingIgnoreCase(String name) {
        return artistRepository.findByArtistNameContainingIgnoreCase(name);
    }

    @Override
    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public void deleteById(Long id) {
        artistRepository.deleteById(id);
    }
}
