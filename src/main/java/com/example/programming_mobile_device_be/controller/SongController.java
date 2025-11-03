package com.example.programming_mobile_device_be.controller;

import com.example.programming_mobile_device_be.dto.request.song.SongCreateRequest;
import com.example.programming_mobile_device_be.dto.request.song.SongUpdateRequest;
import com.example.programming_mobile_device_be.dto.response.ApiResponse;
import com.example.programming_mobile_device_be.dto.response.song.SongResponse;
import com.example.programming_mobile_device_be.entity.Album;
import com.example.programming_mobile_device_be.entity.Song;
import com.example.programming_mobile_device_be.mapper.SongMapper;
import com.example.programming_mobile_device_be.service.AlbumService;
import com.example.programming_mobile_device_be.service.SongService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private  SongService songService;
    @Autowired
    private  SongMapper songMapper;
    @Autowired
    private  AlbumService albumService;

    @GetMapping
    public ApiResponse<List<SongResponse>> getAll() {
        List<SongResponse> list = songService.getAllSongs()
                .stream().map(songMapper::toResponse).collect(Collectors.toList());
        return ApiResponse.<List<SongResponse>>builder().message("Fetched all songs").result(list).build();
    }

    @GetMapping("/{id}")
    public ApiResponse<SongResponse> getById(@PathVariable Long id) {
        return songService.getSongById(id)
                .map(song -> ApiResponse.<SongResponse>builder().result(songMapper.toResponse(song)).build())
                .orElse(ApiResponse.<SongResponse>builder().code(404).message("Song not found").build());
    }

    @PostMapping
    public ApiResponse<SongResponse> create(@Valid @RequestBody SongCreateRequest req) {
        Album album = albumService.getAlbumById(req.getAlbumId()).orElse(null);
        if (album == null)
            return ApiResponse.<SongResponse>builder().code(404).message("Album not found").build();

        Song song = songMapper.toEntity(req, album);
        songService.saveSong(song);
        return ApiResponse.<SongResponse>builder().message("Song created").result(songMapper.toResponse(song)).build();
    }

    @PutMapping("/{id}")
    public ApiResponse<SongResponse> update(@PathVariable Long id, @Valid @RequestBody SongUpdateRequest req) {
        return songService.getSongById(id)
                .map(s -> {
                    s.setSongTitle(req.getSongTitle());
                    s.setDuration(req.getDuration());
                    songService.saveSong(s);
                    return ApiResponse.<SongResponse>builder().message("Song updated").result(songMapper.toResponse(s)).build();
                })
                .orElse(ApiResponse.<SongResponse>builder().code(404).message("Song not found").build());
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        songService.deleteSong(id);
        return ApiResponse.<Void>builder().message("Song deleted").build();
    }

    @GetMapping("/search")
    public ApiResponse<List<SongResponse>> search(@RequestParam("name") String name) {
        List<SongResponse> list = songService.searchByTitle(name)
                .stream().map(songMapper::toResponse).collect(Collectors.toList());
        return ApiResponse.<List<SongResponse>>builder().message("Search done").result(list).build();
    }
}
