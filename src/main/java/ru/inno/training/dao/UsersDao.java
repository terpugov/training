package ru.inno.training.dao;

import ru.inno.training.dao.exceptions.DataException;
import ru.inno.training.pojo.Users;

import java.util.List;

/**
 * Created by mikhail on 24/12/16.
 */
public interface UsersDao<E, T, U> {



    public List<U> readUsers();
    public void createUser(String name, String surname, String email, boolean admin, String password);
    public String getAuth(String email) throws DataException;
    public Users getUserByEmail(String email) throws DataException;
    public Boolean getAdmin(String email) throws DataException;
/*    public void deleteUser(int id);
    public void updateUser(T excercise);*/

}
