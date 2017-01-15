package ru.inno.training.dao;

import ru.inno.training.dao.exceptions.DataException;
import ru.inno.training.pojo.Excercise;

import java.util.List;

/**
 * Created by mikhail on 24/12/16.
 */
public interface ExcerciseDao<E> {


    List<E> readExcercise() throws DataException;
    void deleteExcercise(Excercise excercise) throws DataException;
    void addExcercise(String name, String description, String complexity, String type);


}
