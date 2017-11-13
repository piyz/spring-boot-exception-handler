package by.matrosov.springexceptionhandler.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//ResponseEntityExceptionHandler - Данный класс занимается обработкой ошибок.
//ExceptionHandler. Используется для обработки собственных и каких-то специфичных исключений.
@ControllerAdvice
public class AwesomeExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<AwesomeException> handlerUserNotFoundException(){
        return new ResponseEntity<AwesomeException>(new AwesomeException("User Not Found"), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class AwesomeException{
        private String message;
    }

}
