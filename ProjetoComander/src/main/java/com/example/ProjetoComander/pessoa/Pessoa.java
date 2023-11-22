package com.example.ProjetoComander.pessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

//Cria uma tabela com o nome da classe
@Entity
//Gera todos os métodos de get
@Getter
//Gera todos os métodos de set
@Setter
//Declara construtores sem argumentos
@NoArgsConstructor
//Declara construtores com argumentos
@AllArgsConstructor
//Indica que o ID representa a classe Pessoa
@EqualsAndHashCode

public class Pessoa {

    @Id
    private String pessoaCPF;

    private String pessoaNome;

    private String pessoaDataDeNascimento;

    private String pessoaRG;

    private String pessoaEndereco;

    private String pessoaTelefone;

    public Pessoa(PessoaRequestDTO data){
        this.pessoaCPF = data.pessoaCPF();
        this.pessoaNome = data.pessoaNome();
        this.pessoaDataDeNascimento = data.pessoaDataDeNascimento();
        this.pessoaRG = data.pessoaRG();
        this.pessoaEndereco = data.pessoaEndereco();
        this.pessoaTelefone = data.pessoaTelefone();
    }
}
