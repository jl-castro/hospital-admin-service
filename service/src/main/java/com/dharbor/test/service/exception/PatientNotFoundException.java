package com.dharbor.test.service.exception;

/**
 * @author Jorge Castro
 */
public class PatientNotFoundException extends ApplicationException {

    public PatientNotFoundException(String message) {
        super(message);
    }
}
