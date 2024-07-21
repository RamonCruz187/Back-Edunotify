package com.mensajeria.escolar.security.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalHandlerException {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseMessage> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
        ErrorResponseMessage message = ErrorResponseMessage.builder()
                .message(ex.getMessage())
                .path(request.getDescription(false))
                .status(HttpStatus.NOT_FOUND)
                .timeStamp(LocalDateTime.now())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler({ValidationIntegrity.class})
    public ResponseEntity<ErrorResponseMessage> handlerValidationIntegrity(RuntimeException ex, HttpServletRequest request){
        ErrorResponseMessage message = ErrorResponseMessage.builder()
                .message(ex.getCause().getMessage())
                .path(request.getContextPath())
                .status(HttpStatus.UNAUTHORIZED)
                .timeStamp(LocalDateTime.now())
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
    }
}
