package com.example.cadastro.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "cursos")
@Entity(name= "cursos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Curso{
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
