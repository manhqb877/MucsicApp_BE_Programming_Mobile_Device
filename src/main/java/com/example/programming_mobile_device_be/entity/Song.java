package com.example.programming_mobile_device_be.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "songs")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String songId;

    @Column(nullable = false)
    String songTitle;

    String duration;

    @ManyToOne
    @JoinColumn(name = "album_id")
    Album album;

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL)
    List<PlaylistSong> playlistSongs;
}
