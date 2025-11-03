package com.example.programming_mobile_device_be.entity;

import com.example.programming_mobile_device_be.entity.Artist;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "albums")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String albumId;

    String title;
    LocalDateTime releaseDate;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    Artist artist;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    List<Song> songs;
}