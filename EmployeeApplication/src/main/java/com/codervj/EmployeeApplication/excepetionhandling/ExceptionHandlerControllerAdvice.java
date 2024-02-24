package com.codervj.EmployeeApplication.excepetionhandling;

import com.codervj.EmployeeApplication.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ExceptionHandlerControllerAdvice helps to handle the Exceptions and send the
 * respective Error code and Error message in Error Response
 *
 */
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse handleResourceNotFound(final ResourceNotFoundException exception) {

        ErrorResponse error = new ErrorResponse();
        error.setErrorMessage(exception.getMessage());
        error.setErrorCode(HttpStatus.NOT_FOUND.value());

        return error;
    }
}
