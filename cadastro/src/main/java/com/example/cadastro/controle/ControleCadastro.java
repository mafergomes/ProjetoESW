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
import org.springframework.http.ResponseEntity;
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
    @PutMapping
    public ResponseEntity atualizarAluno(@PathVariable long id,
                                 @RequestBody Aluno aluno) {
        return repositoryAluno.findById(id)
                .map(record -> {
                    record.setAlunoNIS(aluno.getAlunoNIS());
                    record.setAlunoObservacao(aluno.getAlunoObservacao());
                    Aluno updated = repositoryAluno.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity <?> deletarAluno(@PathVariable long id) {
        return repositoryAluno.findById(id)
                .map(record -> {
                    repositoryAluno.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
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

    @PutMapping
    public ResponseEntity atualizarCurso(@PathVariable long id,
                                 @RequestBody Curso curso) {
        return repositoryCurso.findById(id)
                .map(record -> {
                    record.setCursoID(curso.getCursoID());
                    record.setCursoNome(curso.getCursoNome());
                    record.setCursoPeriodo(curso.getCursoPeriodo());
                    record.setCursoProfessor(curso.getCursoProfessor());
                    Curso updated = repositoryCurso.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity <?> deletarCurso(@PathVariable long id) {
        return repositoryCurso.findById(id)
                .map(record -> {
                    repositoryCurso.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
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

    @PutMapping
    public ResponseEntity atualizarEscola(@PathVariable long id,
                                         @RequestBody Escola escola) {
        return repositoryEscola.findById(id)
                .map(record -> {
                    record.setEscolaID(escola.getEscolaID());
                    record.setEscolaNome(escola.getEscolaNome());
                    record.setEscolaPeriodo(escola.getEscolaPeriodo());
                    record.setEscolaAno(escola.getEscolaAno());
                    Escola updated = repositoryEscola.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity <?> deletarEscola(@PathVariable long id) {
        return repositoryEscola.findById(id)
                .map(record -> {
                    repositoryEscola.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
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

    @PutMapping
    public ResponseEntity atualizarFuncionario(@PathVariable long id,
                                         @RequestBody Funcionario funcionario) {
        return repositoryFuncionario.findById(id)
                .map(record -> {
                    record.setFuncionarioID(funcionario.getFuncionarioID());
                    record.setFuncionarioFuncao(funcionario.getFuncionarioFuncao());
                    Funcionario updated = repositoryFuncionario.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity <?> deletarFuncionario(@PathVariable long id) {
        return repositoryFuncionario.findById(id)
                .map(record -> {
                    repositoryFuncionario.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
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

    @PutMapping
    public ResponseEntity atualizarParente(@PathVariable long id,
                                         @RequestBody Parente parente) {
        return repositoryParente.findById(id)
                .map(record -> {
                    record.setParenteResponsavelCPF(parente.getParenteResponsavelCPF());
                    record.setParenteResponsavelNome(parente.getParenteResponsavelNome());
                    record.setParenteFiliacao(parente.getParenteFiliacao());
                    record.setParenteResponsavelMatricula(parente.getParenteResponsavelMatricula());
                    Parente updated = repositoryParente.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity <?> deletarParente(@PathVariable long id) {
        return repositoryParente.findById(id)
                .map(record -> {
                    repositoryParente.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
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

    @PutMapping
    public ResponseEntity atualizarPessoa(@PathVariable String id,
                                         @RequestBody Pessoa pessoa) {
        return repositoryPessoa.findById(id)
                .map(record -> {
                    record.setPessoaCPF(pessoa.getPessoaCPF());
                    record.setPessoaNome(pessoa.getPessoaNome());
                    record.setPessoaDataDeNascimento(pessoa.getPessoaDataDeNascimento());
                    record.setPessoaRG(pessoa.getPessoaRG());
                    record.setPessoaEndereco(pessoa.getPessoaEndereco());
                    record.setPessoaTelefone(pessoa.getPessoaTelefone());
                    Pessoa updated = repositoryPessoa.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity <?> deletarPessoa(@PathVariable String id) {
        return repositoryPessoa.findById(id)
                .map(record -> {
                    repositoryPessoa.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
