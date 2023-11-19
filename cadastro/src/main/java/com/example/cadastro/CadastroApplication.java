package com.example.cadastro;

import com.example.cadastro.pessoa.Pessoa;
import com.example.cadastro.pessoa.PessoaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class CadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroApplication.class, args);
	}

	@Bean
	CommandLineRunner init(PessoaRepository repository) {
		return args -> {
			//repository.getAllPessoas();
			LongStream.range(1, 11)
					.mapToObj(i -> {
						Pessoa p = new Pessoa();
						p.setPessoaCPF("CPF: " + i);
						p.setPessoaNome("Nome: " + i);
						p.setPessoaRG("RG: " + i);
						return p;
					})
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};
	}
}
