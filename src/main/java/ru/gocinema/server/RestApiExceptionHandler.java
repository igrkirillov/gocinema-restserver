package ru.gocinema.server;

import jakarta.validation.ValidationException;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.gocinema.restapi.model.Error;

@RestControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> errorHandler(Exception ex) {
        ex.printStackTrace();
        var error = new Error();
        error.setMessage(ex.getMessage());
        switch (ex) {
            case ValidationException e -> {
                error.setCode(1);
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
            }
            case NoSuchElementException e -> {
                error.setCode(2);
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
            }
            default -> {
                error.setCode(999);
                return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
