package ru.inno.training.dao;

import ru.inno.training.pojo.Excercise;

import java.util.List;

/**
 * Created by mikhail on 24/12/16.
 */
public interface ExcerciseDao<E> {


    List<E> readExcercise();
    void deleteExcercise(Excercise excercise);
    void addExcercise(String name, String description, String complexity, String type);


}
