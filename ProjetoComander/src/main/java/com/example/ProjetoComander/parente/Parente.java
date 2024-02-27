package com.example.ProjetoComander.parente;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class Parente {

    @Id
    private String parenteResponsavelCPF;

    private String parenteResponsavelNome;

    private String parenteFiliacao;

    private String parenteResponsavelMatricula;
    public Parente(ParenteRequestDTO data){
        this.parenteResponsavelCPF = data.parenteResponsavelCPF();
        this.parenteResponsavelNome = data.parenteResponsavelNome();
        this.parenteFiliacao = data.parenteFiliacao();
        this.parenteResponsavelMatricula = data.parenteResponsavelMatricula();
    }
}