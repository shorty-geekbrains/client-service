package ru.geekbrains.clientservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.geekbrains.clientservice.exceptions.ClientNotFoundException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = ClientNotFoundException.class)
    public ResponseEntity<?> handleClientNotFoundException(ClientNotFoundException clientNotFoundException) {
        return new ResponseEntity<>(clientNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
