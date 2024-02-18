package com.learning.basics.project.reactor.exception;

public class NetworkException extends RuntimeException {
    String message;

    public NetworkException(String message) {
        super(message);
        this.message = message;
    }

    public NetworkException(Throwable ex) {
        super(ex);
        this.message = message;
    }
}