public class IndexNotCorrectException extends RuntimeException {
    public IndexNotCorrectException() {
    }

    public IndexNotCorrectException(String message) {
        super(message);
    }

    public IndexNotCorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexNotCorrectException(Throwable cause) {
        super(cause);
    }

    public IndexNotCorrectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
