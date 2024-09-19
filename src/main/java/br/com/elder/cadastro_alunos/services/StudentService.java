package br.com.elder.cadastro_alunos.services;

import br.com.elder.cadastro_alunos.entities.Student;
import br.com.elder.cadastro_alunos.repository.StudentRepository;
import br.com.elder.cadastro_alunos.requests.StudentRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student insert(StudentRequest studentRequest) {

        Student student = new Student();
        BeanUtils.copyProperties(studentRequest, student);

        student.setRegistration(LocalDate.now());

        return studentRepository.save(student);
    }


}
