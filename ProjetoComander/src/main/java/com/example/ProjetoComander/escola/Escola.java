package com.example.ProjetoComander.escola;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class Escola{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long escolaID;

    private String escolaNome;

    private String escolaPeriodo;

    private int escolaAno;

    private int escolaMatricula;

    public Escola(EscolaRequestDTO data){
        this.escolaNome = data.escolaNome();
        this.escolaPeriodo = data.escolaPeriodo();
        this.escolaAno = data.escolaAno();
        this.escolaMatricula = data.escolaMatricula();
    }
}
