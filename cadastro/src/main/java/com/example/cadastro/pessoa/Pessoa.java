package com.example.cadastro.pessoa;

import jakarta.persistence.*;
import lombok.*;

@Table(name= "pessoas")
@Entity(name= "pessoas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String pessoaCPF;

    private String pessoaNome;

    private String pessoaDataDeNascimento;

    private String pessoaRG;

    private String pessoaEndereco;

    private String pessoaTelefone;

    public Pessoa(PessoaRequestDTO data){
        this.pessoaNome = data.pessoaNome();
        this.pessoaDataDeNascimento = data.pessoaDataDeNascimento();
        this.pessoaRG = data.pessoaRG();
        this.pessoaEndereco = data.pessoaEndereco();
        this.pessoaTelefone = data.pessoaTelefone();
    }
}
