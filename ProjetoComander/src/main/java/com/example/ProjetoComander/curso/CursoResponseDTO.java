package com.example.ProjetoComander.curso;

public record CursoResponseDTO(Long cursoID, String cursoNome, String cursoPeriodo, String cursoProfessor) {

    public CursoResponseDTO(Curso curso){
        this(curso.getCursoID(),
                curso.getCursoNome(),
                curso.getCursoPeriodo(),
                curso.getCursoProfessor());
    }
}
