package br.com.elder.cadastro_alunos.services;

import br.com.elder.cadastro_alunos.entities.Student;
import br.com.elder.cadastro_alunos.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }


}
