package br.com.elder.cadastro_alunos.repository;

import br.com.elder.cadastro_alunos.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
