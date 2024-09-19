package br.com.elder.cadastro_alunos.requests;

import br.com.elder.cadastro_alunos.entities.Curso;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {

    private String name;
    private String RA;
    private String CPF;
    private String email;
    private Curso curso;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateBirth;

}
