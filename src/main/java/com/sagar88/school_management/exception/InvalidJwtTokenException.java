package com.sagar88.school_management.exception;

public class InvalidJwtTokenException extends Exception {
    public InvalidJwtTokenException(String message) {
        super(message);
    }
}
