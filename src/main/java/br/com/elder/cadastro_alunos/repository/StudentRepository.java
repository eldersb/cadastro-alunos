package br.com.elder.cadastro_alunos.repository;

import br.com.elder.cadastro_alunos.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
