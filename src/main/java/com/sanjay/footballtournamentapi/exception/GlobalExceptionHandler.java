package com.sanjay.footballtournamentapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidateErrors(
            MethodArgumentNotValidException exception
    ) {
        Map<String,String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error->{
            errors.put(
                    error.getField(),
                    error.getDefaultMessage()
            );
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TournamentNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleTournamentNotFoundException(
            TournamentNotFoundException exception
    ) {
        Map<String, String> error = new HashMap<>();

        error.put("message", exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TournamentGroupNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleTournamentGroupNotFoundException(
            TournamentGroupNotFoundException exception
    ) {
        Map<String, String> error = new HashMap<>();

        error.put("message", exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TeamNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleTeamNotFoundException(
            TeamNotFoundException exception
    ) {
        Map<String, String> error = new HashMap<>();

        error.put("message", exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FootballMatchNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleFootballMatchNotFoundException(
            FootballMatchNotFoundException exception
    ) {
        Map<String, String> error = new HashMap<>();

        error.put("message", exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(
            IllegalArgumentException exception
    ) {
        Map<String, String> error = new HashMap<>();

        error.put("message", exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

