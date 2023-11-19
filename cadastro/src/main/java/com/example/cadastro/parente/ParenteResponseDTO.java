package com.example.cadastro.parente;

public record ParenteResponseDTO(Long parenteResponsavelCPF, String parenteResponsavelNome, String parenteFiliacao, String parenteResponsavelMatricula) {

    public ParenteResponseDTO(Parente parente){
        this(parente.getParenteResponsavelCPF(), parente.getParenteResponsavelNome(), parente.getParenteFiliacao(), parente.getParenteResponsavelMatricula());
    }

}
