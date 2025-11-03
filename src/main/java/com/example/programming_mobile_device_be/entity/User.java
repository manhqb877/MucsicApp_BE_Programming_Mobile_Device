package com.example.programming_mobile_device_be.entity;

import com.example.programming_mobile_device_be.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String userId;

    @Column(nullable = false, unique = true)
    String username;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String password;

    LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    Gender gender;

    // User có nhiều playlist
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Playlist> playlists;

    // User có nhiều comment
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Comment> comments;

    // User có nhiều Role (và Role có nhiều User)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<Role> roles;
}