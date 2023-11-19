package com.example.cadastro.controle;

import com.example.cadastro.aluno.Aluno;
import com.example.cadastro.aluno.*;
import com.example.cadastro.curso.Curso;
import com.example.cadastro.curso.*;
import com.example.cadastro.escola.Escola;
import com.example.cadastro.escola.*;
import com.example.cadastro.funcionario.Funcionario;
import com.example.cadastro.funcionario.*;
import com.example.cadastro.parente.Parente;
import com.example.cadastro.parente.*;
import com.example.cadastro.pessoa.Pessoa;
import com.example.cadastro.pessoa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class ControleCadastro {

    @Autowired
    private AlunoRepository repositoryAluno;

    @Autowired
    private CursoRepository repositoryCurso;

    @Autowired
    private EscolaRepository repositoryEscola;

    @Autowired
    private FuncionarioRepository repositoryFuncionario;

    @Autowired
    private ParenteRepository repositoryParente;

    @Autowired
    private PessoaRepository repositoryPessoa;

    @PostMapping
    public void salvarAluno(@RequestBody AlunoRequestDTO data){
        Aluno alunoData = new Aluno(data);
        repositoryAluno.save(alunoData);
    }

    @GetMapping
    public List<AlunoResponseDTO> getAllAlunos(){
        List<AlunoResponseDTO> listaDeAlunos = repositoryAluno.findAll().stream().map(AlunoResponseDTO::new).toList();
        return listaDeAlunos;
    }

    @PostMapping
    public void salvarCurso(@RequestBody CursoRequestDTO data){
        Curso cursoData = new Curso(data);
        repositoryCurso.save(cursoData);
    }

    @GetMapping
    public List<CursoResponseDTO> getAllCursos(){
        List<CursoResponseDTO> listaDeCursos = repositoryCurso.findAll().stream().map(CursoResponseDTO::new).toList();
        return listaDeCursos;
    }

    @PostMapping
    public void salvarEscola(@RequestBody EscolaRequestDTO data){
        Escola escolaData = new Escola(data);
        repositoryEscola.save(escolaData);
    }

    @GetMapping
    public List<EscolaResponseDTO> getAllEscolas(){
        List<EscolaResponseDTO> listaDeEscolas = repositoryEscola.findAll().stream().map(EscolaResponseDTO::new).toList();
        return listaDeEscolas;
    }

    @PostMapping
    public void salvarFuncionario(@RequestBody FuncionarioRequestDTO data){
        Funcionario funcionarioData = new Funcionario(data);
        repositoryFuncionario.save(funcionarioData);
    }

    @GetMapping
    public List<FuncionarioResponseDTO> getAllFuncionarios(){
        List<FuncionarioResponseDTO> listaDeFuncionarios = repositoryFuncionario.findAll().stream().map(FuncionarioResponseDTO::new).toList();
        return listaDeFuncionarios;
    }

    @PostMapping
    public void salvarParente(@RequestBody ParenteRequestDTO data){
        Parente parenteData = new Parente(data);
        repositoryParente.save(parenteData);
    }

    @GetMapping
    public List<ParenteResponseDTO> getAllParentes(){
        List<ParenteResponseDTO> listaDeParentes = repositoryParente.findAll().stream().map(ParenteResponseDTO::new).toList();
        return listaDeParentes;
    }

    @PostMapping
    public void salvarPessoa(@RequestBody PessoaRequestDTO data){
        Pessoa pessoaData = new Pessoa(data);
        repositoryPessoa.save(pessoaData);
    }

    @GetMapping
    public List<PessoaResponseDTO> getAllPessoas(){
        List<PessoaResponseDTO> listaDePesoas = repositoryPessoa.findAll().stream().map(PessoaResponseDTO::new).toList();
        return listaDePesoas;
    }
}
