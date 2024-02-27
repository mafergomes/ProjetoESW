package com.example.ProjetoComander.funcionario;

import com.example.ProjetoComander.pessoa.Pessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Funcionario extends Pessoa {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funcionarioID;

    private String funcionarioFuncao;

    public Funcionario(FuncionarioRequestDTO data){
        this.funcionarioFuncao = data.funcionarioFuncao();
    }
}

