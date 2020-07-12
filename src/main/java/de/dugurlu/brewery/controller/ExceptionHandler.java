package de.dugurlu.brewery.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
  @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List> handleValidationError(MethodArgumentNotValidException e) {
    List<ObjectError> bindingErrors = e.getBindingResult().getAllErrors();
    var errors = new ArrayList<String>(bindingErrors.size());
    bindingErrors.forEach(error -> {
      errors.add(error.toString());
    });
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }
}
