package ru.inno.training.daoImpl.exceptions;

import ru.inno.training.dao.exceptions.DataException;
import ru.inno.training.daoImpl.ExcersiceDaoImpl;

/**
 * Created by mikhail on 4/01/17.
 */
public class UserDataException extends DataException{
    public UserDataException() {
    }

    public UserDataException(String message) {
        super(message);
    }

    public UserDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDataException(Throwable cause) {
        super(cause);
    }

    public UserDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
