package exception;

public class OutsideSelectException extends RuntimeException{
    public OutsideSelectException(String message) {
        super(message);
    }
}
