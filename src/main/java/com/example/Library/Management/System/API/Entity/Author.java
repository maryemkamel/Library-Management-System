package com.example.Library.Management.System.API.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fName;
    private String lName;
    private Date date_de_Naissance;
    private Date date_de_Deces;
    private String nationalité;
    private String Biographie;

    @OneToMany
    private List<Book> books=new ArrayList<>();


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Date getDate_de_Naissance() {
        return date_de_Naissance;
    }

    public void setDate_de_Naissance(Date date_de_Naissance) {
        this.date_de_Naissance = date_de_Naissance;
    }

    public Date getDate_de_Deces() {
        return date_de_Deces;
    }

    public void setDate_de_Deces(Date date_de_Deces) {
        this.date_de_Deces = date_de_Deces;
    }

    public String getNationalité() {
        return nationalité;
    }

    public void setNationalité(String nationalité) {
        this.nationalité = nationalité;
    }

    public String getBiographie() {
        return Biographie;
    }

    public void setBiographie(String biographie) {
        Biographie = biographie;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
