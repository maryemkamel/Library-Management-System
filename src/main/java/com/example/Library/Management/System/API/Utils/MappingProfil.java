package com.example.Library.Management.System.API.Utils;

import com.example.Library.Management.System.API.Entity.Author;
import com.example.Library.Management.System.API.Entity.Book;
import com.example.Library.Management.System.API.Entity.Dto.*;
import com.example.Library.Management.System.API.Entity.Genre;
import com.example.Library.Management.System.API.Entity.LibraryMember;
import org.modelmapper.ModelMapper;

public class MappingProfil {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static Author mapToAuthorEntity(AuthorRequestDto authorDto) {
        return modelMapper.map(authorDto, Author.class);
    }
    public static Book mapToBookEntity(BookRequestDto bookDto) {
        return modelMapper.map(bookDto, Book.class);
    }
    public static Genre mapToGenreEntity(GenreRequestDto genreDto) {
        return modelMapper.map(genreDto, Genre.class);
    }
    public static LibraryMember mapToLibraryMemberEntity(LibraryMemberRequestDto libraryMemberRequestDto) {
        return modelMapper.map(libraryMemberRequestDto, LibraryMember.class);
    }


    public static BookResponseDto mapToBookDto(Book book) {
        return modelMapper.map(book, BookResponseDto.class);
    }
    public static AuthorResponseDto mapToAuthorDto(Author author) {
        return modelMapper.map(author, AuthorResponseDto.class);
    }
    public static GenreResponseDto mapToGenreDto(Genre genre) {
        return modelMapper.map(genre, GenreResponseDto.class);
    }
    public static LibraryMemberResponseDto mapToLibraryMemberDto(LibraryMember libraryMember) {
        return modelMapper.map(libraryMember, LibraryMemberResponseDto.class);
    }
    /*
    static {
        Converter<User, UserResponseDto> userToUserResponseDtoConverter = new Converter<User, UserResponseDto>() {
            public UserResponseDto convert(MappingContext<User, UserResponseDto> context) {
                User source = context.getSource();
                UserResponseDto destination = new UserResponseDto();
                destination.setId(source.getId());
                destination.setEmail(source.getEmail());
                destination.setFullName(source.getFirstName() + " " + source.getLastName());
                return destination;
            }
        };
        modelMapper.addConverter(userToUserResponseDtoConverter);
    }*/
}
