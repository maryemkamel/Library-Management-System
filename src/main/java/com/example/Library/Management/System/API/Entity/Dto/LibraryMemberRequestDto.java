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
public class LibraryMemberRequestDto {
    private Long id;
    private String fName;
    private String lName;
    private Date date_de_Naissance;
    private int telephone;
    private String email;


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
}
