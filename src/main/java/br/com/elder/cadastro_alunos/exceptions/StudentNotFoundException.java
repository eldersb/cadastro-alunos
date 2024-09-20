package br.com.elder.cadastro_alunos.exceptions;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message) {
        super(message);
    }
}
