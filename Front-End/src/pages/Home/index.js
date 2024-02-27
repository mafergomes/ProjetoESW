import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import Button from "../../components/Button";
import useAuth from "../../hooks/useAuth";
import * as C from "./styles";

const Home = () => {
    const [alunos, setAlunos] = useState([]);
    const [nome, setNome] = useState('');
    const [idade, setIdade] = useState('');
    const [curso, setCurso] = useState('');

  const { signout } = useAuth();
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    // Cria um novo objeto aluno com os dados do formulário
    const novoAluno = { nome, idade, curso };
    // Atualiza o estado dos alunos com o novo aluno adicionado
    setAlunos([...alunos, novoAluno]);
    // Limpa os campos do formulário
    setNome('');
    setIdade('');
    setCurso('');
  };

  return (
    <div style={styles.container}>
      <h1 style={styles.heading}>Cadastro de Alunos</h1>
      <form onSubmit={handleSubmit}>
        <div style={styles.formGroup}>
          <label style={styles.label} htmlFor="nome">Nome:</label>
          <input
            type="text"
            id="nome"
            value={nome}
            onChange={(e) => setNome(e.target.value)}
            style={styles.input}
            required
          />
        </div>
        <div style={styles.formGroup}>
          <label style={styles.label} htmlFor="idade">Idade:</label>
          <input
            type="number"
            id="idade"
            value={idade}
            onChange={(e) => setIdade(e.target.value)}
            style={styles.input}
            required
          />
        </div>
        <div style={styles.formGroup}>
          <label style={styles.label} htmlFor="curso">Curso:</label>
          <input
            type="text"
            id="curso"
            value={curso}
            onChange={(e) => setCurso(e.target.value)}
            style={styles.input}
            required
          />
        </div>
        <button type="submit" style={styles.button}>Cadastrar</button>
      </form>
      <div>
        <h2 style={styles.alunosHeading}>Alunos Cadastrados</h2>
        <ul>
          {alunos.map((aluno, index) => (
            <li key={index} style={styles.alunoItem}>
              <strong>{aluno.nome}</strong> - {aluno.idade} anos - {aluno.curso}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

const styles = {
    container: {
      maxWidth: '400px',
      margin: '50px auto',
      padding: '20px',
      border: '1px solid #ccc',
      borderRadius: '5px',
    },
    heading: {
      textAlign: 'center',
    },
    formGroup: {
      marginBottom: '20px',
    },
    label: {
      display: 'block',
      fontWeight: 'bold',
    },
    input: {
      width: '100%',
      padding: '8px',
      fontSize: '16px',
    },
    button: {
      width: '100%',
      padding: '10px',
      backgroundColor: '#007bff',
      color: '#fff',
      border: 'none',
      borderRadius: '5px',
      cursor: 'pointer',
    },
    alunosHeading: {
      marginTop: '40px',
    },
    alunoItem: {
      marginBottom: '10px',
    },
  };

export default Home;