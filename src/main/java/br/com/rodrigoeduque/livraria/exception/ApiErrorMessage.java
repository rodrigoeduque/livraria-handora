package br.com.rodrigoeduque.livraria.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ApiErrorMessage {

    private HttpStatus status;

    private Integer code;

    private LocalDateTime timestamp;

    private List<Object> error;

    @Deprecated
    public ApiErrorMessage(HttpStatus status, Integer code, LocalDateTime timestamp, String error) {
        this.status = status;
        this.code = code;
        this.timestamp = timestamp;
        this.error = Arrays.asList(error);
    }

    public ApiErrorMessage(HttpStatus status, Integer code, LocalDateTime timestamp, List<Object> errors) {
        this.status = status;
        this.code = code;
        this.timestamp = timestamp;
        this.error = errors;
    }

    public ApiErrorMessage() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public List<Object> getError() {
        return error;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setError(List<Object> error) {
        this.error = error;
    }
}
