package ru.inno.training.service;

import org.apache.tomcat.dbcp.dbcp2.PoolingDataSource;
import ru.inno.training.dao.ExcerciseDao;
import ru.inno.training.daoImpl.ExcersiceDaoImpl;

/**
 * Created by mikhail on 30/12/16.
 */
public class AdminService {


    public static void addExcercise(String name, String description, String complexity, String type){
        ExcerciseDao excersiceDao = new ExcersiceDaoImpl();
        excersiceDao.addExcercise(name, description, complexity, type);
    }
}
