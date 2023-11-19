package com.example.cadastro.escola;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "escolas")
@Entity(name= "escolas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

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