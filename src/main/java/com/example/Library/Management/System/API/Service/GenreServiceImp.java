package com.example.Library.Management.System.API.Service;

import com.example.Library.Management.System.API.Entity.Dto.GenreRequestDto;
import com.example.Library.Management.System.API.Entity.Dto.GenreResponseDto;
import com.example.Library.Management.System.API.Repository.BookRepository;
import com.example.Library.Management.System.API.Repository.GenreRepository;
import com.example.Library.Management.System.API.Utils.MappingProfil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class GenreServiceImp implements GenreService{

    @Autowired
    private final GenreRepository genreRepository;

    public GenreServiceImp(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<GenreResponseDto> getAllGenres() {
        return genreRepository.findAll().stream()
                .map(MappingProfil::mapToGenreDto)
                .collect(Collectors.toList());
    }

    @Override
    public GenreResponseDto createGenre(GenreRequestDto genreDto) {
        var genre = MappingProfil.mapToGenreEntity(genreDto);
        return MappingProfil.mapToGenreDto(genreRepository.save(genre));    }

    @Override
    public GenreResponseDto getGenreById(Long id) throws Exception {
        var genre = genreRepository.findById(id).orElseThrow(() -> new Exception("Genre not found"));
        return MappingProfil.mapToGenreDto(genre);
    }

    @Override
    public GenreResponseDto updateGenre(Long id, GenreRequestDto genreDto) throws Exception {
        var genre = genreRepository.findById(id).orElseThrow(() -> new Exception("Book not found"));
        genre.setNom(genreDto.getNom());
        return MappingProfil.mapToGenreDto(genreRepository.save(genre));    }

    @Override
    public void deleteGenre(Long id) throws Exception {
        var genre = genreRepository.findById(id).orElseThrow(() -> new Exception("Genre not found"));
        genreRepository.delete(genre);
    }
}
