package com.example.programming_mobile_device_be.entity;

import com.example.programming_mobile_device_be.entity.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "playlists")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String playlistId;

    String name;
    String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    List<PlaylistSong> playlistSongs;
}
