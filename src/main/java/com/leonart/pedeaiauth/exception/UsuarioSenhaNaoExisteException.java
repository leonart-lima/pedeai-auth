package com.leonart.pedeaiauth.exception;

public class UsuarioSenhaNaoExisteException extends RuntimeException {
    public UsuarioSenhaNaoExisteException() {
        super("Ocorreu um erro ao autenticar o usuário: usuário ou senha estão invalidos.");
    }

    public UsuarioSenhaNaoExisteException(String message) {
        super(message);
    }
}
