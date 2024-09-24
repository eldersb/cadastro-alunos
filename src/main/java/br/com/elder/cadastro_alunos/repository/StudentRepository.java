package br.com.elder.cadastro_alunos.repository;

import br.com.elder.cadastro_alunos.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByCpf(String cpf);
    Optional<Student> findByRa(String ra);
    Optional<Student> findByEmail(String email);

}
