package com.example.ProjetoComander.aluno;

import com.example.ProjetoComander.pessoa.Pessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode

public class Aluno extends Pessoa {

    //@Id
    private String alunoNIS;

    private String alunoObservacao;

    public Aluno(AlunoRequestDTO data) {
        this.alunoNIS = data.alunoNIS();
        this.alunoObservacao = data.alunoObservacao();
    }
}
