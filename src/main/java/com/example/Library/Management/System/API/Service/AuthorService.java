package com.example.Library.Management.System.API.Service;

import com.example.Library.Management.System.API.Entity.Dto.AuthorRequestDto;
import com.example.Library.Management.System.API.Entity.Dto.AuthorResponseDto;

import java.util.List;

public interface AuthorService {
    List<AuthorResponseDto> getAllAuthors();
    AuthorResponseDto createAuthor(AuthorRequestDto authorDto);
    AuthorResponseDto getAuthorById(Long id) throws Exception;
    AuthorResponseDto updateAuthor(Long id, AuthorRequestDto authorDto) throws Exception;
    void deleteAuthor(Long id) throws Exception;
}
