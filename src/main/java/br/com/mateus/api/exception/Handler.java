package br.com.mateus.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {
    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<String> handlerInvalidId(){
        return ResponseEntity.badRequest().body("Id no formato inválido");
    }

    @ExceptionHandler(IdNotFound.class)
    public ResponseEntity<String> handlerIdNotFound(){
        return ResponseEntity.notFound().build();
    }
    
}
