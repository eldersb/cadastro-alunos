package br.com.elder.cadastro_alunos.controller;

import br.com.elder.cadastro_alunos.entities.Student;
import br.com.elder.cadastro_alunos.requests.StudentRequest;
import br.com.elder.cadastro_alunos.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class RegistrationController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @PostMapping
    public ResponseEntity<Student> insert(@RequestBody StudentRequest studentRequest) {
        Student student = studentService.insert(studentRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }


}
