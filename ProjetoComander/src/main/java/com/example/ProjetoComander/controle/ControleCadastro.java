package com.example.ProjetoComander.controle;

import com.example.ProjetoComander.aluno.Aluno;
import com.example.ProjetoComander.aluno.AlunoRepository;
import com.example.ProjetoComander.aluno.AlunoRequestDTO;
import com.example.ProjetoComander.aluno.AlunoResponseDTO;
import com.example.ProjetoComander.curso.Curso;
import com.example.ProjetoComander.curso.CursoRepository;
import com.example.ProjetoComander.curso.CursoRequestDTO;
import com.example.ProjetoComander.curso.CursoResponseDTO;
import com.example.ProjetoComander.escola.Escola;
import com.example.ProjetoComander.escola.EscolaRepository;
import com.example.ProjetoComander.escola.EscolaRequestDTO;
import com.example.ProjetoComander.escola.EscolaResponseDTO;
import com.example.ProjetoComander.funcionario.Funcionario;
import com.example.ProjetoComander.funcionario.FuncionarioRepository;
import com.example.ProjetoComander.funcionario.FuncionarioRequestDTO;
import com.example.ProjetoComander.funcionario.FuncionarioResponseDTO;
import com.example.ProjetoComander.parente.Parente;
import com.example.ProjetoComander.parente.ParenteRepository;
import com.example.ProjetoComander.parente.ParenteRequestDTO;
import com.example.ProjetoComander.parente.ParenteResponseDTO;
import com.example.ProjetoComander.pessoa.Pessoa;
import com.example.ProjetoComander.pessoa.PessoaRepository;
import com.example.ProjetoComander.pessoa.PessoaRequestDTO;
import com.example.ProjetoComander.pessoa.PessoaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping

public class ControleCadastro {

    @Autowired
    private PessoaRepository repositoryPessoa;

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

    @GetMapping(value = "/pessoa/{id}")
    public List<PessoaResponseDTO> getAllPessoa(){
        List<PessoaResponseDTO> listaDePessoas = repositoryPessoa.findAll().stream().map(PessoaResponseDTO::new).toList();
        return listaDePessoas;
    }

    @PostMapping(value = "/pessoa/{id}")
    public void salvarPessoa(@RequestBody PessoaRequestDTO data){
        Pessoa pessoaData = new Pessoa(data);
        repositoryPessoa.save(pessoaData);
    }

    @PutMapping(value = "/pessoa/{id}")
    public ResponseEntity atualizarPessoa(@PathVariable("id") String id,
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

    @DeleteMapping(value = "/pessoa/{id}")
    public ResponseEntity <?> deletarPessoa(@PathVariable String id) {
        return repositoryPessoa.findById(id)
                .map(record -> {
                    repositoryPessoa.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/aluno/{id}")
    public List<AlunoResponseDTO> getAllAluno(){
        List<AlunoResponseDTO> listaDeAlunos = repositoryAluno.findAll().stream().map(AlunoResponseDTO::new).toList();
        return listaDeAlunos;
    }

    @PostMapping(value = "/aluno/{id}")
    public void salvarAluno(@RequestBody AlunoRequestDTO data){
        Aluno alunoData = new Aluno(data);
        repositoryAluno.save(alunoData);
    }

    @PutMapping(value = "/aluno/{id}")
    public ResponseEntity atualizarAluno(@PathVariable("id") String id,
                                          @RequestBody Aluno aluno) {
        return repositoryAluno.findById(id)
                .map(record -> {
                    record.setAlunoNIS(aluno.getAlunoNIS());
                    record.setAlunoObservacao(aluno.getAlunoObservacao());
                    Aluno updated = repositoryAluno.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/aluno/{id}")
    public ResponseEntity <?> deletarAluno(@PathVariable String id) {
        return repositoryAluno.findById(id)
                .map(record -> {
                    repositoryAluno.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/curso/{id}")
    public List<CursoResponseDTO> getAllCurso(){
        List<CursoResponseDTO> listaDeCursos = repositoryCurso.findAll().stream().map(CursoResponseDTO::new).toList();
        return listaDeCursos;
    }

    @PostMapping(value = "/curso/{id}")
    public void salvarCurso(@RequestBody CursoRequestDTO data){
        Curso cursoData = new Curso(data);
        repositoryCurso.save(cursoData);
    }

    @PutMapping(value = "/curso/{id}")
    public ResponseEntity atualizarCurso(@PathVariable("id") Long id,
                                         @RequestBody Curso curso) {
        return repositoryCurso.findById(id)
                .map(record -> {
                    record.setCursoNome(curso.getCursoNome());
                    record.setCursoPeriodo(curso.getCursoPeriodo());
                    record.setCursoProfessor(curso.getCursoProfessor());
                    Curso updated = repositoryCurso.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/curso/{id}")
    public ResponseEntity <?> deletarCurso(@PathVariable Long id) {
        return repositoryCurso.findById(id)
                .map(record -> {
                    repositoryCurso.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/escola/{id}")
    public List<EscolaResponseDTO> getAllEscola(){
        List<EscolaResponseDTO> listaDeEscolas = repositoryEscola.findAll().stream().map(EscolaResponseDTO::new).toList();
        return listaDeEscolas;
    }

    @PostMapping(value = "/escola/{id}")
    public void salvarEscola(@RequestBody EscolaRequestDTO data){
        Escola escolaData = new Escola(data);
        repositoryEscola.save(escolaData);
    }

    @PutMapping(value = "/escola/{id}")
    public ResponseEntity atualizarEscola(@PathVariable("id") Long id,
                                         @RequestBody Escola escola) {
        return repositoryEscola.findById(id)
                .map(record -> {
                    record.setEscolaNome(escola.getEscolaNome());
                    record.setEscolaPeriodo(escola.getEscolaPeriodo());
                    record.setEscolaAno(escola.getEscolaAno());
                    record.setEscolaMatricula(escola.getEscolaMatricula());
                    Escola updated = repositoryEscola.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/escola/{id}")
    public ResponseEntity <?> deletarEscola(@PathVariable Long id) {
        return repositoryEscola.findById(id)
                .map(record -> {
                    repositoryEscola.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/funcionario/{id}")
    public List<FuncionarioResponseDTO> getAllFuncionario(){
        List<FuncionarioResponseDTO> listaDeFuncionarios = repositoryFuncionario.findAll().stream().map(FuncionarioResponseDTO::new).toList();
        return listaDeFuncionarios;
    }

    @PostMapping(value = "/funcionario/{id}")
    public void salvarFuncionario(@RequestBody FuncionarioRequestDTO data){
        Funcionario funcionarioData = new Funcionario(data);
        repositoryFuncionario.save(funcionarioData);
    }

    @PutMapping(value = "/funcionario/{id}")
    public ResponseEntity atualizarFuncionario(@PathVariable("id") Long id,
                                          @RequestBody Funcionario funcionario) {
        return repositoryFuncionario.findById(id)
                .map(record -> {
                    record.setFuncionarioFuncao(funcionario.getFuncionarioFuncao());
                    Funcionario updated = repositoryFuncionario.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/funcionario/{id}")
    public ResponseEntity <?> deletarFuncionario(@PathVariable Long id) {
        return repositoryFuncionario.findById(id)
                .map(record -> {
                    repositoryFuncionario.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/parente/{id}")
    public List<ParenteResponseDTO> getAllParente(){
        List<ParenteResponseDTO> listaDeParentes = repositoryParente.findAll().stream().map(ParenteResponseDTO::new).toList();
        return listaDeParentes;
    }

    @PostMapping(value = "/parente/{id}")
    public void salvarParente(@RequestBody ParenteRequestDTO data){
        Parente parenteData = new Parente(data);
        repositoryParente.save(parenteData);
    }

    @PutMapping(value = "/parente/{id}")
    public ResponseEntity atualizarParente(@PathVariable("id") String id,
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

    @DeleteMapping(value = "/parente/{id}")
    public ResponseEntity <?> deletarParente(@PathVariable String id) {
        return repositoryParente.findById(id)
                .map(record -> {
                    repositoryParente.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
