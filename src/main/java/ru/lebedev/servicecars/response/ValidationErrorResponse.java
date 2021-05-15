package ru.lebedev.servicecars.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ValidationErrorResponse {

    List<ValidationErrorResponseItem> validationErrors = new ArrayList<>();
}
