package com.example.ProjetoComander.parente;

public record ParenteResponseDTO(String parenteResponsavelCPF, String parenteResponsavelNome, String parenteFiliacao, String parenteResponsavelMatricula) {

    public ParenteResponseDTO(Parente parente){
        this(parente.getParenteResponsavelCPF(),
                parente.getParenteResponsavelNome(),
                parente.getParenteFiliacao(),
                parente.getParenteResponsavelMatricula());
    }

}

