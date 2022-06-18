package com.quatronacoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class BendNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(BendNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String BendNotFoundHandler(BendNotFoundException ex) {
    return ex.getMessage();
  }
}