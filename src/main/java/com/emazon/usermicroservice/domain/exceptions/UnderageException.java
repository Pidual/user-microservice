package com.emazon.usermicroservice.domain.exceptions;

public class UnderageException extends RuntimeException {
    public UnderageException(String message) {
        super(message);
    }
}
