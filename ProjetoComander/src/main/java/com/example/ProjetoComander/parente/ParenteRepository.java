package com.example.ProjetoComander.parente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParenteRepository extends JpaRepository<Parente, String> {
}

//Esta interface, usando o extends, herda todos os métodos de acesso ao banco de dados,
//que vai ser usado pra consultar os dados dentro do banco