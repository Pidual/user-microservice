package com.emazon.usermicroservice.domain.exceptions;

public class WrongEmailException extends RuntimeException {
    public WrongEmailException(String message) {
        super(message);
    }
}
