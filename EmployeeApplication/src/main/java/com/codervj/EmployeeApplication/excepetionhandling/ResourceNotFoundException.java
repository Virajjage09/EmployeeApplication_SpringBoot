package com.codervj.EmployeeApplication.excepetionhandling;

import java.io.Serial;

/**
 * ResourceNotFoundException class used to maintain ResourceNotFoundException user-friendly
 * Error Message that can propagate to respective client
 */
public class ResourceNotFoundException extends Exception {

    @Serial
    private static final long serialVersionUID = -9079454849611061074L;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(final String message) {
        super(message);
    }
}
