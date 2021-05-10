package com.pocket.exceptions;

public class NoFileSelectedException extends Exception {
    public NoFileSelectedException() {
        super(String.format("No document has been selected!"));
    }

}
