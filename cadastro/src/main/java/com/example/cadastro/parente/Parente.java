package com.example.cadastro.parente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "parentes")
@Entity(name= "parentes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Parente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parenteResponsavelCPF;

    private String parenteResponsavelNome;

    private String parenteFiliacao;

    private String parenteResponsavelMatricula;
    public Parente(ParenteRequestDTO data){
        this.parenteResponsavelNome = data.parenteResponsavelNome();
        this.parenteFiliacao = data.parenteFiliacao();
        this.parenteResponsavelMatricula = data.parenteResponsavelMatricula();
    }
}
