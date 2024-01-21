package com.example.toyapi.exception;

public class ToyNotFoundException extends RuntimeException{
    public ToyNotFoundException(String s) {
        super(s);
    }
}
