package com.msoft.projectmanagementsystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * Created On : 2025 03 Jan 3:07 PM
 * Author : Diwash Pokhrel
 * Description:
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SuperAdminException.class)
    public ResponseEntity<String> handleSuperAdminException(SuperAdminException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("Internal Server Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder errorMessages = new StringBuilder();
        for (FieldError error : fieldErrors) {
            errorMessages.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("\n");
        }
        return new ResponseEntity<>(errorMessages.toString(), HttpStatus.BAD_REQUEST);
    }
}

