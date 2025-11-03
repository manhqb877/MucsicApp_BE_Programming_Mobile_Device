package com.example.programming_mobile_device_be.controller;

import com.example.programming_mobile_device_be.dto.request.album.AlbumCreateRequest;
import com.example.programming_mobile_device_be.dto.request.album.AlbumUpdateRequest;
import com.example.programming_mobile_device_be.dto.response.ApiResponse;
import com.example.programming_mobile_device_be.dto.response.album.AlbumResponse;
import com.example.programming_mobile_device_be.entity.Album;
import com.example.programming_mobile_device_be.entity.Artist;
import com.example.programming_mobile_device_be.mapper.AlbumMapper;
import com.example.programming_mobile_device_be.service.AlbumService;
import com.example.programming_mobile_device_be.service.ArtistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private  AlbumService albumService;
    @Autowired
    private  AlbumMapper albumMapper;
    @Autowired
    private  ArtistService artistService;

    @GetMapping
    public ApiResponse<List<AlbumResponse>> getAllAlbums() {
        List<AlbumResponse> list = albumService.getAllAlbums()
                .stream().map(albumMapper::toResponse).collect(Collectors.toList());
        return ApiResponse.<List<AlbumResponse>>builder()
                .message("Fetched all albums successfully")
                .result(list)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<AlbumResponse> getAlbumById(@PathVariable Long id) {
        return albumService.getAlbumById(id)
                .map(album -> ApiResponse.<AlbumResponse>builder()
                        .message("Fetched album successfully")
                        .result(albumMapper.toResponse(album))
                        .build())
                .orElse(ApiResponse.<AlbumResponse>builder()
                        .code(404).message("Album not found").build());
    }

    @PostMapping
    public ApiResponse<AlbumResponse> createAlbum(@Valid @RequestBody AlbumCreateRequest request) {
        Artist artist = artistService.findById(request.getArtistId());
        if (artist == null) {
            return ApiResponse.<AlbumResponse>builder().code(404).message("Artist not found").build();
        }

        Album album = albumMapper.toEntity(request, artist);
        albumService.saveAlbum(album);
        return ApiResponse.<AlbumResponse>builder()
                .message("Album created successfully")
                .result(albumMapper.toResponse(album))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<AlbumResponse> updateAlbum(@PathVariable Long id,
                                                  @Valid @RequestBody AlbumUpdateRequest request) {
        return albumService.getAlbumById(id)
                .map(existing -> {
                    existing.setTitle(request.getTitle());
                    existing.setReleaseDate(request.getReleaseDate());
                    albumService.saveAlbum(existing);
                    return ApiResponse.<AlbumResponse>builder()
                            .message("Album updated successfully")
                            .result(albumMapper.toResponse(existing))
                            .build();
                })
                .orElse(ApiResponse.<AlbumResponse>builder().code(404).message("Album not found").build());
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return ApiResponse.<Void>builder().message("Album deleted successfully").build();
    }

    @GetMapping("/search")
    public ApiResponse<List<AlbumResponse>> searchByTitle(@RequestParam("name") String name) {
        List<AlbumResponse> list = albumService.searchByTitle(name)
                .stream().map(albumMapper::toResponse).collect(Collectors.toList());
        return ApiResponse.<List<AlbumResponse>>builder()
                .message("Search completed")
                .result(list)
                .build();
    }
}
