package com.polytech.touristrootserver.exception;

public class TouristAlreadyExists extends RuntimeException{
    public TouristAlreadyExists(String message) {
        super(message);
    }
}
