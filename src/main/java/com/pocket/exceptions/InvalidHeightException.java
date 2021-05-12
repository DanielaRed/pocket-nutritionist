package com.pocket.exceptions;

public class InvalidHeightException extends Exception{
    public InvalidHeightException() {
        super(String.format("The 'Height' field must contain only digits!"));

    }
}
