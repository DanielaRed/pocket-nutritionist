package com.pocket.exceptions;

public class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException() {
        super(String.format("The phone number must contain only digits!"));

    }
}