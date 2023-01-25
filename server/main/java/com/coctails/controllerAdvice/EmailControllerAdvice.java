package com.coctails.controllerAdvice;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class EmailControllerAdvice {
    @ExceptionHandler(value = IllegalStateException.class)
    public ResponseEntity<String> handleException(Exception e) {
        log.info("handleException");
        log.info("MSG: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
