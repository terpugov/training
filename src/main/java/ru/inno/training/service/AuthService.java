package ru.inno.training.service;

import org.apache.log4j.Logger;
import ru.inno.training.UsersDaoImpl;
import ru.inno.training.dao.UsersDao;
import ru.inno.training.servlets.RegistrationServlet;

/**
 * Created by mikhail on 28/12/16.
 */
public class AuthService {
    private static Logger log = Logger.getLogger(RegistrationServlet.class.getName());
    public boolean checkAuth(String email, String password){

        UsersDao usersDao = new UsersDaoImpl();
        String user_pass = usersDao.getAuth(email);
        log.info("pass and pass "  + user_pass + " " + password );
        if (password.equals(user_pass)){
            return true;

        }
        else{
            return false;
        }
    }
}
