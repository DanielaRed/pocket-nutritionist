package com.pocket.exceptions;

public class InvalidWeightException extends Exception{
    public InvalidWeightException() {
        super(String.format("The 'Weight' field must contain only digits!"));

    }
}
