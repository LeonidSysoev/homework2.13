public class ArrayLengthException extends RuntimeException {
    public ArrayLengthException() {
    }

    public ArrayLengthException(String message) {
        super(message);
    }

    public ArrayLengthException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayLengthException(Throwable cause) {
        super(cause);
    }

    public ArrayLengthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
