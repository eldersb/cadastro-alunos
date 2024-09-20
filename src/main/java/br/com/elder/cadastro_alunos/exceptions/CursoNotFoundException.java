package br.com.elder.cadastro_alunos.exceptions;

public class CursoNotFoundException extends RuntimeException{
    public CursoNotFoundException(String message) {
        super(message);
    }
}
