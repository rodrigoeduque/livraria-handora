package br.com.rodrigoeduque.livraria.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {


        List<Object> errors = new ArrayList<>();

        for (FieldError x : ex.getBindingResult().getFieldErrors()) {

            Map<String,Object> map = new HashMap<>();
            map.put("field : ", x.getField());
            map.put("message : ", x.getDefaultMessage());
            errors.add(map);

        }

        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(status, status.value(), LocalDateTime.now(), errors);
        return new ResponseEntity<>(apiErrorMessage,status);
    }


}
