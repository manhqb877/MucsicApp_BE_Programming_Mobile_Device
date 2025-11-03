package com.example.programming_mobile_device_be.repository;

import com.example.programming_mobile_device_be.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findByArtistNameContainingIgnoreCase(String artistName);
}
