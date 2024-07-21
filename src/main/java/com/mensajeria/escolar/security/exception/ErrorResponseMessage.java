package com.mensajeria.escolar.security.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorResponseMessage implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String message;
    private String path;
    private LocalDateTime timeStamp;
    private HttpStatus status;
    private int statusCode;
}
