package draw.exception;

public class OutOfBoundsException extends Exception { 

    public OutOfBoundsException(int x, int y) {
        super("Point (" + x + "," + y + ") is outside the canvas boundary.");
    }

    
}