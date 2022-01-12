package draw.exception;

public class UnknownCommandTypeException extends Exception { 
    public UnknownCommandTypeException(String message) {
        super(message);
    }
}