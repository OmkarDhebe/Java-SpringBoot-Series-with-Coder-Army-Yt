package in.example.crudSpringBootDemo.exception;

import java.time.LocalDateTime;

public class ExceptionResponseDto {

    private LocalDateTime times;
    private int statusCode;
    private String error;
    private String message;
    private String path;

    public ExceptionResponseDto(LocalDateTime times, int statusCode, String error, String message, String path) {
        this.times = times;
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimes() {
        return times;
    }

    public void setTimes(LocalDateTime times) {
        this.times = times;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
