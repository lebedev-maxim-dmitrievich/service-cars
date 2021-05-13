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

    @ExceptionHandler({CarNotFoundException.class, NumberNotCorrectException.class, OldCarException.class})
    public ResponseEntity<?> carSuitabilityExceptionHandler(Exception e) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
