package ru.inno.training.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mikhail on 24/12/16.
 */
public interface UsersDao<E, T, U> {


    public List<U> readUsers() throws SQLException;
    public void createUser(String name, String surname, String email, boolean admin, String password);
/*    public void deleteUser(int id);
    public void updateUser(T excercise);*/

}
