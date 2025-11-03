package com.example.programming_mobile_device_be.mapper;

import com.example.programming_mobile_device_be.dto.request.user.UserCreateRequest;
import com.example.programming_mobile_device_be.dto.response.user.CommentReponse;
import com.example.programming_mobile_device_be.dto.response.user.PlaylistResponse;
import com.example.programming_mobile_device_be.dto.response.user.UserResponse;
import com.example.programming_mobile_device_be.entity.Comment;
import com.example.programming_mobile_device_be.entity.Playlist;
import com.example.programming_mobile_device_be.entity.Role;
import com.example.programming_mobile_device_be.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    // ✅ Request → Entity
    public User toEntity(UserCreateRequest request, Set<Role> roles) {
        return User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .gender(request.getGender())
                .createdAt(LocalDateTime.now())
                .roles(roles)
                .build();
    }

    // ✅ Entity → Response
    public UserResponse toResponse(User user) {
        List<PlaylistResponse> playlistResponses = null;
        List<CommentReponse> commentResponses = null;

        if (user.getPlaylists() != null) {
            playlistResponses = user.getPlaylists().stream()
                    .map(this::toPlaylistResponse)
                    .collect(Collectors.toList());
        }

        if (user.getComments() != null) {
            commentResponses = user.getComments().stream()
                    .map(this::toCommentResponse)
                    .collect(Collectors.toList());
        }

        return UserResponse.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .email(user.getEmail())
                .gender(user.getGender())
                .createdAt(user.getCreatedAt())
                .roles(user.getRoles().stream()
                        .map(role -> role.getName().name())  // ✅ chuyển enum → String
                        .collect(Collectors.toSet()))
                .playlists(playlistResponses)
                .comments(commentResponses)
                .build();
    }

    public UserResponse toUserResponse(User user) {
        if (user == null) return null;
        return toResponse(user);
    }

    // ✅ Sub-mapper: Playlist
    private PlaylistResponse toPlaylistResponse(Playlist playlist) {
        return PlaylistResponse.builder()
                .playlistId(playlist.getPlaylistId())
                .name(playlist.getName())
                .description(playlist.getDescription())
                .build();
    }

    // ✅ Sub-mapper: Comment
    private CommentReponse toCommentResponse(Comment comment) {
        return CommentReponse.builder()
                .commentID(comment.getCommentId())
                .text(comment.getText())
                .build();
    }
}
