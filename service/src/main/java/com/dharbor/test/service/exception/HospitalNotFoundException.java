package com.dharbor.test.service.exception;

/**
 * @author Jorge Castro
 */
public class HospitalNotFoundException extends ApplicationException {

    public HospitalNotFoundException(String message) {
        super(message);
    }
}
