package com.dharbor.test.service.exception;

/**
 * @author Jorge Castro
 */
public class DoctorNotFoundException extends ApplicationException {

    public DoctorNotFoundException(String message) {
        super(message);
    }
}
