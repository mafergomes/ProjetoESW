package com.example.cadastro.aluno;

import com.example.cadastro.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "alunos")
@Entity(name= "alunos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Aluno extends Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alunoNIS;

    private String alunoObservacao;

    public Aluno(AlunoRequestDTO data){
        this.alunoObservacao = data.alunoObservacao();
    }
}
