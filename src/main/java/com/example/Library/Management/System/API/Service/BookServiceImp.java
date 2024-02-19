package com.example.Library.Management.System.API.Service;

import com.example.Library.Management.System.API.Entity.Dto.BookRequestDto;
import com.example.Library.Management.System.API.Entity.Dto.BookResponseDto;
import com.example.Library.Management.System.API.Repository.AuthorRepository;
import com.example.Library.Management.System.API.Repository.BookRepository;
import com.example.Library.Management.System.API.Utils.MappingProfil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class BookServiceImp implements BookService{
    @Autowired
    private final BookRepository bookRepository;

    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(MappingProfil::mapToBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDto createBook(BookRequestDto bookDto) {
        var book = MappingProfil.mapToBookEntity(bookDto);
        return MappingProfil.mapToBookDto(bookRepository.save(book));
    }

    @Override
    public BookResponseDto getBookById(Long id) throws Exception {
        var book = bookRepository.findById(id).orElseThrow(() -> new Exception("Book not found"));
        return MappingProfil.mapToBookDto(book);
    }

    @Override
    public BookResponseDto updateBook(Long id, BookRequestDto bookDto) throws Exception {
        var book = bookRepository.findById(id).orElseThrow(() -> new Exception("Book not found"));

        book.setTitre(bookDto.getTitre());
        book.setAnnee_Publication(book.getAnnee_Publication());
        book.setLangue(bookDto.getLangue());
        return MappingProfil.mapToBookDto(bookRepository.save(book));
    }

    @Override
    public void deleteBook(Long id) throws Exception {
        var book = bookRepository.findById(id).orElseThrow(() -> new Exception("Book not found"));
        bookRepository.delete(book);
    }
}
