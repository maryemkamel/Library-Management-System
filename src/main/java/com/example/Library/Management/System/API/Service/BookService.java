package com.example.Library.Management.System.API.Service;

import com.example.Library.Management.System.API.Entity.Dto.AuthorRequestDto;
import com.example.Library.Management.System.API.Entity.Dto.AuthorResponseDto;
import com.example.Library.Management.System.API.Entity.Dto.BookRequestDto;
import com.example.Library.Management.System.API.Entity.Dto.BookResponseDto;

import java.util.List;

public interface BookService {
    List<BookResponseDto> getAllBooks();
    BookResponseDto createBook(BookRequestDto bookDto);
    BookResponseDto getBookById(Long id) throws Exception;
    BookResponseDto updateBook(Long id, BookRequestDto bookDto) throws Exception;
    void deleteBook(Long id) throws Exception;
}
