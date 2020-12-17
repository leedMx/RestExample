package com.example.restExcercise.service;

public class DogNotFoundException extends RuntimeException {
    public DogNotFoundException() {
    }

    public DogNotFoundException(String message) {
        super(message);
    }
}
