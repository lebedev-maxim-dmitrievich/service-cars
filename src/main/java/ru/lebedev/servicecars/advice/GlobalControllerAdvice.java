package ru.lebedev.servicecars.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.lebedev.servicecars.exception.CarNotFoundException;
import ru.lebedev.servicecars.exception.NumberNotCorrectException;
import ru.lebedev.servicecars.exception.OldCarException;
import ru.lebedev.servicecars.response.ErrorResponse;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(NumberNotCorrectException.class)
    public ResponseEntity<?> numberNotCorrectHandler(NumberNotCorrectException e) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OldCarException.class)
    public ResponseEntity<?> oldCarHandler(OldCarException e) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<?> carNotFoundHandler(CarNotFoundException e) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
