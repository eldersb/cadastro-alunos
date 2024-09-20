package br.com.elder.cadastro_alunos.requests;

import br.com.elder.cadastro_alunos.entities.Curso;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String RA;

    @NotBlank
    private String CPF;

    @NotBlank
    private String email;

    private Curso curso;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateBirth;

}
