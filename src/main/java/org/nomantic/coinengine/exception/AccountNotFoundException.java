package org.nomantic.coinengine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This custom exception is thrown when an attempt is made to access an account
 * that does not exist in the database.
 * The @ResponseStatus(HttpStatus.NOT_FOUND) annotation tells Spring Boot
 * to automatically return a 404 NOT FOUND error to the client when this exception
 * is thrown from a controller.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String message) {
        super(message);
    }
}