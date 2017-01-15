package ru.inno.training.daoImpl.exceptions;

import ru.inno.training.dao.exceptions.DataException;

/**
 * Created by mikhail on 4/01/17.
 */
public class ExcersiceDataException extends DataException {
    public ExcersiceDataException() {
    }

    public ExcersiceDataException(String message) {
        super(message);
    }

    public ExcersiceDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcersiceDataException(Throwable cause) {
        super(cause);
    }

    public ExcersiceDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
