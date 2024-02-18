package com.learning.basics.project.reactor.exception;

public class ReviewException extends RuntimeException {
    String message;
    public ReviewException(String message) {
        super(message);
        this.message = message;
    }
}