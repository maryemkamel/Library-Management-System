package com.example.Library.Management.System.API.Controller;

import com.example.Library.Management.System.API.Entity.Dto.GenreRequestDto;
import com.example.Library.Management.System.API.Entity.Dto.GenreResponseDto;
import com.example.Library.Management.System.API.Service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public ResponseEntity<List<GenreResponseDto>> getAllGenres() {
        List<GenreResponseDto> genres = genreService.getAllGenres();
        return ResponseEntity.ok(genres);
    }

    @PostMapping
    public ResponseEntity<GenreResponseDto> createGenre(@RequestBody GenreRequestDto genreDto) {
        GenreResponseDto createdGenre = genreService.createGenre(genreDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGenre);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreResponseDto> getGenreById(@PathVariable Long id) throws Exception {
        GenreResponseDto genre = genreService.getGenreById(id);
        return ResponseEntity.ok(genre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreResponseDto> updateGenre(@PathVariable Long id, @RequestBody GenreRequestDto genreDto) throws Exception {
        GenreResponseDto updatedGenre = genreService.updateGenre(id, genreDto);
        return ResponseEntity.ok(updatedGenre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) throws Exception {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }
}
