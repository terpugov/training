package ru.inno.training.service.exceptions;

import ru.inno.training.dao.exceptions.DataException;
import ru.inno.training.daoImpl.exceptions.UserDataException;

/**
 * Created by mikhail on 4/01/17.
 */
public class ServiceException extends DataException {
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
