package com.quatronacoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class CitizenNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(CitizenNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String citizenNotFoundHandler(CitizenNotFoundException ex) {
    return ex.getMessage();
  }
}