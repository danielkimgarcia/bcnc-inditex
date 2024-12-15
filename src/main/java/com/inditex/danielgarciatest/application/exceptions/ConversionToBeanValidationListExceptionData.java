package com.inditex.danielgarciatest.application.exceptions;

import org.springframework.validation.FieldError;

/**
 * This java record class is used to be a java bean validation message conversor to show
 * a friendly message to the user when an validation error occurs on any request
 *
 * @param field
 * @param message
 */
public record ConversionToBeanValidationListExceptionData(String field, String message) {
    public ConversionToBeanValidationListExceptionData(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }
}