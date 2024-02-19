package com.example.Library.Management.System.API.Service;

import com.example.Library.Management.System.API.Entity.Dto.BookRequestDto;
import com.example.Library.Management.System.API.Entity.Dto.BookResponseDto;
import com.example.Library.Management.System.API.Entity.Dto.GenreRequestDto;
import com.example.Library.Management.System.API.Entity.Dto.GenreResponseDto;

import java.util.List;

public interface GenreService {
    List<GenreResponseDto> getAllGenres();
    GenreResponseDto createGenre(GenreRequestDto genreDto);
    GenreResponseDto getGenreById(Long id) throws Exception;
    GenreResponseDto updateGenre(Long id, GenreRequestDto genreDto) throws Exception;
    void deleteGenre(Long id) throws Exception;
}
