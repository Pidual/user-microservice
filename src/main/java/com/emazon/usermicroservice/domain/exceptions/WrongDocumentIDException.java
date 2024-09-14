package com.emazon.usermicroservice.domain.exceptions;

public class WrongDocumentIDException extends RuntimeException {
    public WrongDocumentIDException(String message) {
        super(message);
    }
}
