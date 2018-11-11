package com.hunter.job.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by telly on 30/09/18.
 */
@Getter @Setter @NoArgsConstructor
public class CandidatDto {

    @NotNull
    private String nom;

    @NotNull
    private String prenom;

    private String telephone;

    @NotNull
    private String email;


    public CandidatDto(String nom, String prenom,String telephone,String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
    }
}
