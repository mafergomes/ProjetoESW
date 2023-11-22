package com.example.ProjetoComander.escola;

public record EscolaResponseDTO(Long escolaID, String escolaNome, String escolaPeriodo, int escolaAno, int escolaMatricula) {

    public EscolaResponseDTO(Escola escola){
        this(escola.getEscolaID(),
                escola.getEscolaNome(),
                escola.getEscolaPeriodo(),
                escola.getEscolaAno(),
                escola.getEscolaMatricula());
    }

}