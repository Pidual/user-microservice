package com.emazon.usermicroservice.domain.exceptions;

public class EmptyPasswordException extends RuntimeException {
    public EmptyPasswordException(String message) {
        super(message);
    }
}
