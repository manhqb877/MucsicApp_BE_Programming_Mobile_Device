package com.example.programming_mobile_device_be.service.impl;

import com.example.programming_mobile_device_be.entity.Album;
import com.example.programming_mobile_device_be.entity.Song;
import com.example.programming_mobile_device_be.repository.AlbumRepository;
import com.example.programming_mobile_device_be.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements com.example.programming_mobile_device_be.service.SongService {
    @Autowired
    private SongRepository songRepository;


    @Override
    public List<Song> getAllSongs() { return songRepository.findAll(); }


    @Override
    public Optional<Song> getSongById(Long id) { return songRepository.findById(id); }


    @Override
    public Song saveSong(Song song) { return songRepository.save(song); }


    @Override
    public void deleteSong(Long id) { songRepository.deleteById(id); }


    @Override
    public List<Song> searchByTitle(String title) {
        return songRepository.findBySongTitleContainingIgnoreCase(title);
    }
}
