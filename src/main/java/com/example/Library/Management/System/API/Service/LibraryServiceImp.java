package com.example.Library.Management.System.API.Service;

import com.example.Library.Management.System.API.Entity.Dto.LibraryMemberRequestDto;
import com.example.Library.Management.System.API.Entity.Dto.LibraryMemberResponseDto;
import com.example.Library.Management.System.API.Repository.GenreRepository;
import com.example.Library.Management.System.API.Repository.LibraryMemberRepository;
import com.example.Library.Management.System.API.Utils.MappingProfil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class LibraryServiceImp implements LibraryMemberService{
    @Autowired
    private final LibraryMemberRepository libraryMemberRepository;

    public LibraryServiceImp(LibraryMemberRepository libraryMemberRepository) {
        this.libraryMemberRepository = libraryMemberRepository;
    }

    @Override
    public List<LibraryMemberResponseDto> getAllLibraryMembers() {
        return libraryMemberRepository.findAll().stream()
                .map(MappingProfil::mapToLibraryMemberDto)
                .collect(Collectors.toList());
    }

    @Override
    public LibraryMemberResponseDto createLibraryMember(LibraryMemberRequestDto libraryMemberDto) {
        var libraryMember = MappingProfil.mapToLibraryMemberEntity(libraryMemberDto);
        return MappingProfil.mapToLibraryMemberDto(libraryMemberRepository.save(libraryMember));
    }

    @Override
    public LibraryMemberResponseDto getLibraryMemberById(Long id) throws Exception {
        var libraryMember = libraryMemberRepository.findById(id).orElseThrow(() -> new Exception("LibraryMember not found"));
        return MappingProfil.mapToLibraryMemberDto(libraryMember);
    }

    @Override
    public LibraryMemberResponseDto updateLibraryMember(Long id, LibraryMemberRequestDto LibraryMemberDto) throws Exception {
        var libraryMember = libraryMemberRepository.findById(id).orElseThrow(() -> new Exception("LibraryMember not found"));

        libraryMember.setfName(libraryMember.getfName());
        libraryMember.setlName(libraryMember.getfName());
        libraryMember.setEmail(libraryMember.getEmail());
        libraryMember.setTelephone(libraryMember.getTelephone());
        libraryMember.setDate_de_Naissance(libraryMember.getDate_de_Naissance());
        return MappingProfil.mapToLibraryMemberDto(libraryMemberRepository.save(libraryMember));
    }

    @Override
    public void deleteLibraryMember(Long id) throws Exception {
        var LibraryMemberDto = libraryMemberRepository.findById(id).orElseThrow(() -> new Exception("LibraryMember not found"));
        libraryMemberRepository.delete(LibraryMemberDto);
    }
}
