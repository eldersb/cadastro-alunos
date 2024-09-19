package br.com.elder.cadastro_alunos.entities;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String RA;
    private String CPF;
    private String email;

    @ManyToOne
    @JoinColumn(name = "cursos_id")
    private Curso curso;

    private Date dateBirth;
    private LocalDate registration;


}
