package com.example.programming_mobile_device_be.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "comments")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String commentId;

    @Column(nullable = false, length = 1000)
    String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}