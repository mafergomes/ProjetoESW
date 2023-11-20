package com.example.cadastro.funcionario;

import com.example.cadastro.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "funcionarios")
@Entity(name= "funcionarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Funcionario extends Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funcionarioID;

    private String funcionarioFuncao;

    public Funcionario(FuncionarioRequestDTO data){
        this.funcionarioFuncao = data.funcionarioFuncao();
    }
}

