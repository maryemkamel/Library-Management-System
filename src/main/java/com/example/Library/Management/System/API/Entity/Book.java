package com.example.Library.Management.System.API.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private Date Annee_Publication;
    private String Langue;
    @OneToOne
    private Author author;
    @OneToMany
    private List<Genre> genres = new ArrayList<>();


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getAnnee_Publication() {
        return Annee_Publication;
    }

    public void setAnnee_Publication(Date annee_Publication) {
        Annee_Publication = annee_Publication;
    }

    public String getLangue() {
        return Langue;
    }

    public void setLangue(String langue) {
        Langue = langue;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
