package com.example.ProjetoComander.curso;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class Curso {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cursoID;

    private String cursoNome;

    private String cursoPeriodo;

    private String cursoProfessor;

    public Curso(CursoRequestDTO data){
        this.cursoNome = data.cursoNome();
        this.cursoPeriodo = data.cursoPeriodo();
        this.cursoProfessor = data.cursoProfessor();
    }
}
