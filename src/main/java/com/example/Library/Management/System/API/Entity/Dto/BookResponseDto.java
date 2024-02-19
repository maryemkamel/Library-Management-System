package com.example.Library.Management.System.API.Entity.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
    private Long id;
    private String titre;
    private Date Annee_Publication;
    private String Langue;


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
}
