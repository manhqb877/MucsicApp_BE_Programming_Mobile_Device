package com.example.programming_mobile_device_be.repository;

import com.example.programming_mobile_device_be.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findBySongTitleContainingIgnoreCase(String songTitle);
}
