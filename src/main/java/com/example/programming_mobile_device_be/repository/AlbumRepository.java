package com.example.programming_mobile_device_be.repository;

import com.example.programming_mobile_device_be.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByTitleContainingIgnoreCase(String title);
}
