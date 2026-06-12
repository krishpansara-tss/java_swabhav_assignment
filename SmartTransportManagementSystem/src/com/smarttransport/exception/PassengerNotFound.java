package com.smarttransport.exception;

public class PassengerNotFound extends RuntimeException {
    public PassengerNotFound(String message) {
        super(message);
    }
}
