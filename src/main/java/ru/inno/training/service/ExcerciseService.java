package ru.inno.training.service;

import ru.inno.training.pojo.Excercise;
import ru.inno.training.dao.ExcerciseDao;
import ru.inno.training.ExcersiceDaoImpl;

import java.util.List;

/**
 * Created by mikhail on 28/12/16.
 */
public class ExcerciseService {

    public List<Excercise> getExcercise(){

        ExcerciseDao excerciseDao = new ExcersiceDaoImpl();
        List<Excercise> result = excerciseDao.readExcercise();
        return result;

    }

}
