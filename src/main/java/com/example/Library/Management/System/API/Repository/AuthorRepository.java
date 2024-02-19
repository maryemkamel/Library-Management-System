package com.example.Library.Management.System.API.Repository;

import com.example.Library.Management.System.API.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
