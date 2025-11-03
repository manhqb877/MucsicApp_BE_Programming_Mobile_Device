package com.example.programming_mobile_device_be.controller;

import com.example.programming_mobile_device_be.dto.request.artist.ArtistCreateRequest;
import com.example.programming_mobile_device_be.dto.request.artist.ArtistUpdateRequest;
import com.example.programming_mobile_device_be.dto.response.ApiResponse;
import com.example.programming_mobile_device_be.dto.response.artist.ArtistResponse;
import com.example.programming_mobile_device_be.entity.Artist;
import com.example.programming_mobile_device_be.mapper.ArtistMapper;
import com.example.programming_mobile_device_be.service.ArtistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private ArtistMapper artistMapper;

    // ✅ Lấy tất cả artist
    @GetMapping
    public ApiResponse<List<ArtistResponse>> getAllArtists() {
        List<ArtistResponse> artists = artistService.findAll()
                .stream()
                .map(artistMapper::toResponse)
                .collect(Collectors.toList());

        return ApiResponse.<List<ArtistResponse>>builder()
                .message("Fetched all artists successfully")
                .result(artists)
                .build();
    }

    // ✅ Lấy artist theo ID
    @GetMapping("/{id}")
    public ApiResponse<ArtistResponse> getArtistById(@PathVariable Long id) {
        Artist artist = artistService.findById(id);
        if (artist == null) {
            return ApiResponse.<ArtistResponse>builder()
                    .code(404)
                    .message("Artist not found")
                    .build();
        }

        return ApiResponse.<ArtistResponse>builder()
                .message("Fetched artist successfully")
                .result(artistMapper.toResponse(artist))
                .build();
    }

    // ✅ Tìm artist theo tên (không phân biệt hoa thường)
    @GetMapping("/search")
    public ApiResponse<List<ArtistResponse>> searchArtistsByName(@RequestParam String name) {
        List<ArtistResponse> artists = artistService.findByNameContainingIgnoreCase(name)
                .stream()
                .map(artistMapper::toResponse)
                .collect(Collectors.toList());

        return ApiResponse.<List<ArtistResponse>>builder()
                .message("Fetched artists by name successfully")
                .result(artists)
                .build();
    }

    // ✅ Tạo mới artist
    @PostMapping
    public ApiResponse<ArtistResponse> createArtist(@Valid @RequestBody ArtistCreateRequest request) {
        Artist artist = artistMapper.toEntity(request);
        artistService.save(artist);

        return ApiResponse.<ArtistResponse>builder()
                .message("Artist created successfully")
                .result(artistMapper.toResponse(artist))
                .build();
    }

    // ✅ Cập nhật artist
    @PutMapping("/{id}")
    public ApiResponse<ArtistResponse> updateArtist(
            @PathVariable Long id,
            @Valid @RequestBody ArtistUpdateRequest request
    ) {
        Artist existingArtist = artistService.findById(id);
        if (existingArtist == null) {
            return ApiResponse.<ArtistResponse>builder()
                    .code(404)
                    .message("Artist not found")
                    .build();
        }

        artistMapper.updateEntity(existingArtist, request);
        artistService.save(existingArtist);

        return ApiResponse.<ArtistResponse>builder()
                .message("Artist updated successfully")
                .result(artistMapper.toResponse(existingArtist))
                .build();
    }

    // ✅ Xóa artist
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteArtist(@PathVariable Long id) {
        artistService.deleteById(id);
        return ApiResponse.<Void>builder()
                .message("Artist deleted successfully")
                .build();
    }
}
