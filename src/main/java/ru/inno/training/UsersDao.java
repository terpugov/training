package ru.inno.training;

import ru.inno.training.Users;

import java.util.List;

/**
 * Created by mikhail on 24/12/16.
 */
public interface UsersDao {

    public Users readExcersise();
    public List<Users> readExcercise();
    public void createExcercise();
    public void deleteExcercise(Users excercise);
    public void updateExcercise(Users excercise);

}
