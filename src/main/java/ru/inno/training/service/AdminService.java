package ru.inno.training.service;

import ru.inno.training.daoImpl.ExcersiceDaoImpl;

/**
 * Created by mikhail on 30/12/16.
 */
public class AdminService {

    public static void addExcercise(String name, String description, String complexity, String type){
        ExcersiceDaoImpl excersiceDao = new ExcersiceDaoImpl();
        excersiceDao.addExcercise(name, description, complexity, type);
    }
}
