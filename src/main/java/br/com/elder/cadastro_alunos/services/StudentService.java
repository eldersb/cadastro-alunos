package br.com.elder.cadastro_alunos.services;

import br.com.elder.cadastro_alunos.entities.Student;
import br.com.elder.cadastro_alunos.repository.StudentRepository;
import br.com.elder.cadastro_alunos.requests.StudentRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public Student update(Long id, StudentRequest newStudent){
        Optional<Student> student = getStudentById(id);

        if(student.isPresent()){
            Student studentUpdate = student.get();
            BeanUtils.copyProperties(newStudent, studentUpdate);
            return studentUpdate;
        }

        return null;


    }


    public void remove(Long id) {
        Optional<Student> student = getStudentById(id);

        student.ifPresent(value -> studentRepository.delete(value));
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }


}
