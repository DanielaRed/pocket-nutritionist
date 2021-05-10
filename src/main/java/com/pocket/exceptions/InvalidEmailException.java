package com.pocket.exceptions;

public class InvalidEmailException extends Exception {
    public InvalidEmailException() {
        super(String.format("The email is invalid!"));

    }

}