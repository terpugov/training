package ru.inno.training.service;

import ru.inno.training.dao.exceptions.DataException;
import ru.inno.training.pojo.Excercise;
import ru.inno.training.dao.ExcerciseDao;
import ru.inno.training.daoImpl.ExcersiceDaoImpl;
import ru.inno.training.service.exceptions.ExcerciseServiceException;
import ru.inno.training.service.exceptions.ServiceException;

import java.util.List;

/**
 * Created by mikhail on 28/12/16.
 */
public class ExcerciseService {

    public List<Excercise> getExcercise() throws ServiceException {

        ExcerciseDao excerciseDao = new ExcersiceDaoImpl();
        List<Excercise> result = null;
        try {
            result = excerciseDao.readExcercise();
        } catch (DataException e) {
            ServiceException a = new ExcerciseServiceException();
            throw a;
        }
        return result;

    }

}
