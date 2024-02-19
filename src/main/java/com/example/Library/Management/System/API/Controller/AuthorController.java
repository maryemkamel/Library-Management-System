package com.example.Library.Management.System.API.Controller;

import com.example.Library.Management.System.API.Entity.Dto.AuthorRequestDto;
import com.example.Library.Management.System.API.Entity.Dto.AuthorResponseDto;
import com.example.Library.Management.System.API.Service.AuthorService;
import com.example.Library.Management.System.API.Service.AuthorServiceImp;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponseDto>> getAllAuthors() {
        List<AuthorResponseDto> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @PostMapping
    public ResponseEntity<AuthorResponseDto> createAuthor(@RequestBody AuthorRequestDto authorDto) {
        AuthorResponseDto createdAuthor = authorService.createAuthor(authorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> getAuthorById(@PathVariable Long id) throws Exception {
        AuthorResponseDto author = authorService.getAuthorById(id);
        return ResponseEntity.ok(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> updateAuthor(@PathVariable Long id, @RequestBody AuthorRequestDto authorDto) throws Exception {
        AuthorResponseDto updatedAuthor = authorService.updateAuthor(id, authorDto);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) throws Exception {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
