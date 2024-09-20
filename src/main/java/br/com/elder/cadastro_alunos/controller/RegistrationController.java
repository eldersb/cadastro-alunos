package br.com.elder.cadastro_alunos.controller;

import br.com.elder.cadastro_alunos.entities.Student;
import br.com.elder.cadastro_alunos.exceptions.CursoNotFoundException;
import br.com.elder.cadastro_alunos.exceptions.StudentNotFoundException;
import br.com.elder.cadastro_alunos.requests.StudentRequest;
import br.com.elder.cadastro_alunos.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class RegistrationController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudendById(@PathVariable Long id) throws StudentNotFoundException{
        Optional<Student> student = studentService.getStudentById(id);

        if (student.isEmpty()) {
            throw new StudentNotFoundException("Aluno não encontrado!");
        }

        return ResponseEntity.ok().body(student.get());

    }

    @PostMapping
    public ResponseEntity<Student> insert(@RequestBody @Valid StudentRequest studentRequest) {

        System.out.println("Inserindo aluno: " + studentRequest);

        Student student = studentService.insert(studentRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody StudentRequest newStudent , @PathVariable Long id){

        Optional<Student> student = studentService.getStudentById(id);

        if(student.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Student responseStudent = studentService.update(id, newStudent);

        return ResponseEntity.ok().body(responseStudent);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id) throws StudentNotFoundException {
        Optional<Student> student = studentService.getStudentById(id);

        if(student.isEmpty()){
            throw new StudentNotFoundException("Não foi possível deletar o aluno, pois ele não foi encontrado!");
        }

        studentService.remove(id);

        return ResponseEntity.ok().body(null);

    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleException(StudentNotFoundException ex){
        Map<String, String> reponseMessage = new HashMap<>();
        reponseMessage.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(reponseMessage);
    }



}
