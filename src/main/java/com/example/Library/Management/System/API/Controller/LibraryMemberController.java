package com.example.Library.Management.System.API.Controller;

import com.example.Library.Management.System.API.Entity.Dto.LibraryMemberRequestDto;
import com.example.Library.Management.System.API.Entity.Dto.LibraryMemberResponseDto;
import com.example.Library.Management.System.API.Service.LibraryMemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library-members")
public class LibraryMemberController {

    private final LibraryMemberService libraryMemberService;

    public LibraryMemberController(LibraryMemberService libraryMemberService) {
        this.libraryMemberService = libraryMemberService;
    }

    @GetMapping
    public ResponseEntity<List<LibraryMemberResponseDto>> getAllLibraryMembers() {
        List<LibraryMemberResponseDto> libraryMembers = libraryMemberService.getAllLibraryMembers();
        return ResponseEntity.ok(libraryMembers);
    }

    @PostMapping
    public ResponseEntity<LibraryMemberResponseDto> createLibraryMember(@RequestBody LibraryMemberRequestDto libraryMemberDto) {
        LibraryMemberResponseDto createdLibraryMember = libraryMemberService.createLibraryMember(libraryMemberDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLibraryMember);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryMemberResponseDto> getLibraryMemberById(@PathVariable Long id) throws Exception {
        LibraryMemberResponseDto libraryMember = libraryMemberService.getLibraryMemberById(id);
        return ResponseEntity.ok(libraryMember);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryMemberResponseDto> updateLibraryMember(@PathVariable Long id, @RequestBody LibraryMemberRequestDto libraryMemberDto) throws Exception {
        LibraryMemberResponseDto updatedLibraryMember = libraryMemberService.updateLibraryMember(id, libraryMemberDto);
        return ResponseEntity.ok(updatedLibraryMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibraryMember(@PathVariable Long id) throws Exception {
        libraryMemberService.deleteLibraryMember(id);
        return ResponseEntity.noContent().build();
    }
}
