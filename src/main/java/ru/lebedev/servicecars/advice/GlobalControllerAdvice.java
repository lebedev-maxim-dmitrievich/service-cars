package ru.lebedev.servicecars.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.lebedev.servicecars.exception.*;
import ru.lebedev.servicecars.response.ErrorResponse;
import ru.lebedev.servicecars.response.ValidationErrorResponse;
import ru.lebedev.servicecars.response.ValidationErrorResponseItem;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<?> carNotFoundExceptionHandler(Exception e) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StatusException.class)
    public ResponseEntity<?> statusExceptionHandler(Exception e) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DeleteCarException.class)
    public ResponseEntity<?> deleteCarExceptionHandler(Exception e) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UpdateCarException.class)
    public ResponseEntity<?> updateCarExceptionHandler(Exception e) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse();
        e.getFieldErrors().forEach(fieldError -> {
            ValidationErrorResponseItem item = new ValidationErrorResponseItem();
            item.setField(fieldError.getField());
            item.setMessage(fieldError.getDefaultMessage());
            validationErrorResponse.getValidationErrors().add(item);
        });

        return new ResponseEntity<>(validationErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
