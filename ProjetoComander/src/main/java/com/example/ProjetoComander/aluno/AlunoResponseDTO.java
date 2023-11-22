package com.example.ProjetoComander.aluno;

import com.example.ProjetoComander.pessoa.PessoaResponseDTO;

public record AlunoResponseDTO(String alunoNIS, String alunoObservacao) {

    public AlunoResponseDTO(Aluno aluno){
        this(aluno.getAlunoNIS(),
                aluno.getAlunoObservacao());
    }

}
