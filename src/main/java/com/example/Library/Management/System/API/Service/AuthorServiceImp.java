package com.example.Library.Management.System.API.Service;

import com.example.Library.Management.System.API.Entity.Dto.AuthorRequestDto;
import com.example.Library.Management.System.API.Entity.Dto.AuthorResponseDto;
import com.example.Library.Management.System.API.Repository.AuthorRepository;
import com.example.Library.Management.System.API.Utils.MappingProfil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class AuthorServiceImp implements AuthorService{
    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorServiceImp(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<AuthorResponseDto> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(MappingProfil::mapToAuthorDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorResponseDto createAuthor(AuthorRequestDto authorDto) {
        var task = MappingProfil.mapToAuthorEntity(authorDto);
        return MappingProfil.mapToAuthorDto(authorRepository.save(task));
    }

    @Override
    public AuthorResponseDto getAuthorById(Long id) throws Exception {
        var author = authorRepository.findById(id).orElseThrow(() -> new Exception("Author not found"));
        return MappingProfil.mapToAuthorDto(author);
    }

    @Override
    public AuthorResponseDto updateAuthor(Long id, AuthorRequestDto authorDto) throws Exception {
        var author = authorRepository.findById(id).orElseThrow(() -> new Exception("Author not found"));

        author.setfName(authorDto.getfName());
        author.setlName(authorDto.getlName());
        author.setDate_de_Naissance(authorDto.getDate_de_Naissance());
        author.setBiographie(author.getBiographie());
        author.setDate_de_Deces(author.getDate_de_Deces());
        author.setNationalité(author.getNationalité());
        return MappingProfil.mapToAuthorDto(authorRepository.save(author));
    }

    @Override
    public void deleteAuthor(Long id) throws Exception {
        var author = authorRepository.findById(id).orElseThrow(() -> new Exception("Author not found"));
        authorRepository.delete(author);
    }
}
