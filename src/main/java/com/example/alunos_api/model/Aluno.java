package com.example.alunos_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String ra;

    @Column(nullable = false)
    private String curso;

    @Column(nullable = false)
    private String turma;

    @Column(name = "status_matricula", nullable = false)
    private Boolean statusMatricula;

    public Aluno(String nome, String ra, String curso, String turma, Boolean statusMatricula) {
        this.nome = nome;
        this.ra = ra;
        this.curso = curso;
        this.turma = turma;
        this.statusMatricula = statusMatricula;
    }

    public Aluno() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getRa() { return ra; }
    public void setRa(String ra) { this.ra = ra; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public String getTurma() { return turma; }
    public void setTurma(String turma) { this.turma = turma; }

    public Boolean getStatusMatricula() { return statusMatricula; }
    public void setStatusMatricula(Boolean statusMatricula) { this.statusMatricula = statusMatricula; }
}