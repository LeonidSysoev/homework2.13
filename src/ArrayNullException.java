public class ArrayNullException extends RuntimeException {
    public ArrayNullException() {
    }

    public ArrayNullException(String message) {
        super(message);
    }

    public ArrayNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayNullException(Throwable cause) {
        super(cause);
    }

    public ArrayNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
