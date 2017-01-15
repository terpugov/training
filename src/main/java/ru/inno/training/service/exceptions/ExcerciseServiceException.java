package ru.inno.training.service.exceptions;

/**
 * Created by mikhail on 4/01/17.
 */
public class ExcerciseServiceException extends ServiceException {
    public ExcerciseServiceException() {
    }

    public ExcerciseServiceException(String message) {
        super(message);
    }

    public ExcerciseServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcerciseServiceException(Throwable cause) {
        super(cause);
    }

    public ExcerciseServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
