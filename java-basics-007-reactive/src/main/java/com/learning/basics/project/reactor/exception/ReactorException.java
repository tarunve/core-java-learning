package com.learning.basics.project.reactor.exception;

public class ReactorException extends Throwable {
    private Throwable excpetion;
    private String message;

    public ReactorException(Throwable exception, String message) {
        this.excpetion = exception;
        this.message = message;

    }
}