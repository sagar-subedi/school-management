package com.sagar88.schoolmanagement.exception;

public class InvalidJwtTokenException extends Exception {
    public InvalidJwtTokenException(String message) {
        super(message);
    }
}
