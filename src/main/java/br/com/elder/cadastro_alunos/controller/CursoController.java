package br.com.elder.cadastro_alunos.controller;

import br.com.elder.cadastro_alunos.entities.Curso;
import br.com.elder.cadastro_alunos.exceptions.CursoNotFoundException;
import br.com.elder.cadastro_alunos.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping
    public List<Curso> getAll() {
        return cursoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) throws CursoNotFoundException{
        Optional<Curso> curso = cursoService.getCursoById(id);

        if(curso.isEmpty()) {
            throw new CursoNotFoundException("Curso não encontrado!");
        }

        return ResponseEntity.ok().body(curso.get());

    }

    @ExceptionHandler(CursoNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleException(CursoNotFoundException ex){
        Map<String, String> reponseMessage = new HashMap<>();
        reponseMessage.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(reponseMessage);
    }

}
