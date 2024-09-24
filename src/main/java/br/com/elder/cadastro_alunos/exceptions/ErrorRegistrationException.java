package br.com.elder.cadastro_alunos.exceptions;

import java.util.List;

public class ErrorRegistrationException extends RuntimeException {
    private final List<String> messages;

    public ErrorRegistrationException(List<String> messages) {
        super(String.join(", ", messages));
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }
}
