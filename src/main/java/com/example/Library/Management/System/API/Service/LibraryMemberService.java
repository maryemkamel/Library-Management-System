package com.example.Library.Management.System.API.Service;

import com.example.Library.Management.System.API.Entity.Dto.GenreRequestDto;
import com.example.Library.Management.System.API.Entity.Dto.GenreResponseDto;
import com.example.Library.Management.System.API.Entity.Dto.LibraryMemberRequestDto;
import com.example.Library.Management.System.API.Entity.Dto.LibraryMemberResponseDto;

import java.util.List;

public interface LibraryMemberService {
    List<LibraryMemberResponseDto> getAllLibraryMembers();
    LibraryMemberResponseDto createLibraryMember(LibraryMemberRequestDto libraryMemberDto);
    LibraryMemberResponseDto getLibraryMemberById(Long id) throws Exception;
    LibraryMemberResponseDto updateLibraryMember(Long id, LibraryMemberRequestDto LibraryMemberDto) throws Exception;
    void deleteLibraryMember(Long id) throws Exception;
}
