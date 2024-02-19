package com.example.Library.Management.System.API.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "LibraryMember")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibraryMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fName;
    private String lName;
    private Date date_de_Naissance;
    private int telephone;
    private String email;
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

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
