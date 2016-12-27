package ru.inno.training;

import javax.sound.midi.Soundbank;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Main{

    public static void main(String[] args) throws SQLException {

        UsersDaoImpl userdao = new UsersDaoImpl();
        List<Users> users = userdao.readUsers();
        ExcerciseDao excerciseDao = new ExcersiceDaoImpl();
        List<Excercise> excercises = excerciseDao.readExcercise();

        for (Users user : users){

            System.out.println(user.getId() + " " + user.getUserName() + " " +  user.getUserSurname() +  " " + user.getUserEmail());
        }

//        userdao.createUser("Anton", "Popov", "popov@ya.ru", false, "123pop");
        for (Excercise excercise: excercises){
            System.out.println(excercise.getName() + " " + excercise.getDescription());
        }


    }
}