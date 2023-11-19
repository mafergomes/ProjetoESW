package com.example.cadastro.aluno;

public record AlunoResponseDTO(Long alunoNIS, String alunoObservacao) {
    public AlunoResponseDTO(Aluno aluno) {
        this(aluno.getAlunoNIS(), aluno.getAlunoObservacao());
    }
}
