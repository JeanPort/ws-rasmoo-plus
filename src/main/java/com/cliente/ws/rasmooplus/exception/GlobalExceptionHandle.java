package com.cliente.ws.rasmooplus.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(NotFoundExcption.class)
    public ResponseEntity<ErrorResponse> handlerNotFoundException(NotFoundExcption e) {
        var error = new ErrorResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var fieldErrors = e.getFieldErrors();

        var list = fieldErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();

        var message = String.join(", ", list);

        var error = new ErrorResponse(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


}
