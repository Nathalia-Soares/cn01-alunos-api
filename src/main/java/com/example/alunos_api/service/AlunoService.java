package com.example.alunos_api.service;

import com.example.alunos_api.model.Aluno;
import com.example.alunos_api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno criarAluno(Aluno aluno) {
        if (alunoRepository.existsByRa(aluno.getRa())) {
            throw new RuntimeException("RA já existe");
        }
        return alunoRepository.save(aluno);
    }

    public List<Aluno> buscarTodosAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public Optional<Aluno> buscarAlunoPorRa(String ra) {
        return alunoRepository.findByRa(ra);
    }

    public Aluno atualizarAluno(Long id, Aluno alunoAtualizado) {
        return alunoRepository.findById(id)
                .map(alunos -> {
                    if (!alunos.getRa().equals(alunoAtualizado.getRa()) &&
                            alunoRepository.existsByRa(alunoAtualizado.getRa())) {
                        throw new RuntimeException("RA já existe");
                    }
                    alunos.setNome(alunoAtualizado.getNome());
                    alunos.setRa(alunoAtualizado.getRa());
                    alunos.setCurso(alunoAtualizado.getCurso());
                    alunos.setTurma(alunoAtualizado.getTurma());
                    alunos.setStatusMatricula(alunoAtualizado.getStatusMatricula());
                    return alunoRepository.save(alunos);
                })
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    public void deletarAluno(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado");
        }
        alunoRepository.deleteById(id);
    }
}