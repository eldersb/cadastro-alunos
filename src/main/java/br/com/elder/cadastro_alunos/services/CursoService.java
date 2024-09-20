package br.com.elder.cadastro_alunos.services;

import br.com.elder.cadastro_alunos.entities.Curso;
import br.com.elder.cadastro_alunos.entities.Student;
import br.com.elder.cadastro_alunos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    public List<Curso> getAll() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> getCursoById(Long id) {
        return cursoRepository.findById(id);
    }

}
