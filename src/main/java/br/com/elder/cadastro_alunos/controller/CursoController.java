package br.com.elder.cadastro_alunos.controller;

import br.com.elder.cadastro_alunos.entities.Curso;
import br.com.elder.cadastro_alunos.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping
    public List<Curso> getAll() {
        return cursoService.getAll();
    }

}
