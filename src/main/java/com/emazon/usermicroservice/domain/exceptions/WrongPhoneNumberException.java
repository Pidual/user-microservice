package com.emazon.usermicroservice.domain.exceptions;

public class WrongPhoneNumberException extends RuntimeException {
    public WrongPhoneNumberException(String message) {
        super(message);
    }
}
