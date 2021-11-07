package com.dharbor.test.service.exception;

/**
 * @author Jorge Castro
 */
public abstract class ApplicationException extends RuntimeException {
    public ApplicationException() {
    }

    public ApplicationException(String message) {
        super(message);
    }
}
