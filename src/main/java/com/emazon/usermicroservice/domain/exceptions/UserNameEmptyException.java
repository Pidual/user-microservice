package com.emazon.usermicroservice.domain.exceptions;

public class UserNameEmptyException extends RuntimeException {
    public UserNameEmptyException(String message) {
        super(message);
    }
}
