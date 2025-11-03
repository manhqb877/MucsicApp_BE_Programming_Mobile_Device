package com.example.programming_mobile_device_be.entity;

import com.example.programming_mobile_device_be.entity.Playlist;
import com.example.programming_mobile_device_be.entity.Song;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "playlist_song")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaylistSong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "song_id")
    Song song;

    LocalDateTime dateAdd;
}
