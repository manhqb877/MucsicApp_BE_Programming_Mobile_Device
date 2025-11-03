package com.example.programming_mobile_device_be.repository;

import com.example.programming_mobile_device_be.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    List<Playlist> findByNameContainingIgnoreCase(String name);
}
