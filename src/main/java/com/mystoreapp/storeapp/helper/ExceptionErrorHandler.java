package com.mystoreapp.storeapp.helper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionErrorHandler {
 @ExceptionHandler(Exception.class)
  public  ResponseEntity<?> handleException(Exception e){
        return ResponseEntity.badRequest().body(ErrorDto.builder().message(e.getClass().getSimpleName()).errorCode(33).build());
    }
}
