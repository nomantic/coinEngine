package org.nomantic.coinengine.exception;

import org.nomantic.coinengine.utill.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleAccountNotFound(AccountNotFoundException exception) {
        ApiResponse<String> response = new ApiResponse<>(false, exception.getMessage(), null);
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }
}
