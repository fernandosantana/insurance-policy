package com.build.policy.api.handle;

import com.build.policy.exception.NotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class HandleException {

    @ExceptionHandler(TypeMismatchException.class)
    public HttpStatus handleTypeMismatchException(TypeMismatchException e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid value '${e.value}'", e);
    }

    @ExceptionHandler(NotFoundException.class)
    public HttpStatus handleNotFoundException(NotFoundException e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
    }

    @ExceptionHandler(Exception.class)
    public HttpStatus handleException(Exception e) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
    }
}
