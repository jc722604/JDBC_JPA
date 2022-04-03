package hw2.exception;

import java.time.LocalDateTime;

/**
 * This class attributes will be returned to the client as a part of customized exception handling
 */

public class ExceptionResponse {

    private String message;
    private LocalDateTime dataTime;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public void setDataTime(LocalDateTime dataTime) {
        this.dataTime = dataTime;
    }
}
