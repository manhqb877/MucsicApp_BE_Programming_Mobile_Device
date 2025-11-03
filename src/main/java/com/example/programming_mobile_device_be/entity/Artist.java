package com.example.programming_mobile_device_be.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "artists")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String artistId;

    @Column(nullable = false)
    String artistName;

    String country;
    String bio;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    List<Album> albums;
}
