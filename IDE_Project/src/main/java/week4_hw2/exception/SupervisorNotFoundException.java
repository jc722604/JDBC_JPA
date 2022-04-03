package hw2.exception;

public class SupervisorNotFoundException extends RuntimeException{
    public SupervisorNotFoundException(String message) {
        super(message);
    }
}
