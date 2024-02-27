package com.example.ProjetoComander.funcionario;

public record FuncionarioResponseDTO(Long funcionarioID, String funcionarioFuncao) {

    public FuncionarioResponseDTO(Funcionario funcionario){
        this(funcionario.getFuncionarioID(),
                funcionario.getFuncionarioFuncao());
    }

}
