package com.github.barbarastefany.dslist.exceptions;

public class GameNotFoundException extends RuntimeException {

    public GameNotFoundException() {
        super("Jogo não encontrado.");
    }
}
