package com.example.cadastro.pessoa;

public record PessoaResponseDTO(String pessoaCPF, String pessoaNome, String pessoaDataDeNascimento, String pessoaRG, String pessoaEndereco, String pessoaTelefone) {

    public PessoaResponseDTO(Pessoa pessoa) {
        this(pessoa.getPessoaCPF(),
                pessoa.getPessoaNome(),
                pessoa.getPessoaDataDeNascimento(),
                pessoa.getPessoaRG(),
                pessoa.getPessoaEndereco(),
                pessoa.getPessoaTelefone());
    }

}
