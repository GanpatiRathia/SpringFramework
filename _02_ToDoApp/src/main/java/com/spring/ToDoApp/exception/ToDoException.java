package com.spring.ToDoApp.exception;

/**
 * Custom exception class for handling To-Do related errors.
 */
public class ToDoException extends RuntimeException {
    public ToDoException(String message) {
        super(message);
    }
}
