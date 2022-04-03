package hw2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> handleEmptyInput(EmployeeNotFoundException emptyInputException) {
        return new ResponseEntity<>("Input file is empty, Please check it!", HttpStatus.BAD_REQUEST);
    }
}
