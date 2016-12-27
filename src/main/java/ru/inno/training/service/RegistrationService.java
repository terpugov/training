package ru.inno.training.service;

import ru.inno.training.Users;
import ru.inno.training.UsersDao;
import ru.inno.training.UsersDaoImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mikhail on 27/12/16.
 */
public class RegistrationService {
    UsersDao usersDao = new UsersDaoImpl();

    public void addUserToDB(String name, String surname, String email, boolean bolean,  String password){

        if (password != ""){
            usersDao.createUser(name, surname, email, bolean, password);
        }

    }
    public boolean checkAvailiableEmail(String email)  {

        try {
            List<Users> usersList = usersDao.readUsers();
            for( Users u : usersList){

                if (email.equals(u.getUserEmail())){
                    return false;
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
