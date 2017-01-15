package ru.inno.training.service;

import org.apache.log4j.Logger;
//import org.jetbrains.annotations.Nullable;
import ru.inno.training.dao.exceptions.DataException;
import ru.inno.training.daoImpl.UsersDaoImpl;
import ru.inno.training.dao.UsersDao;
import ru.inno.training.pojo.Users;
import ru.inno.training.service.exceptions.AuthServiceException;
import ru.inno.training.service.exceptions.ServiceException;
import ru.inno.training.servlets.RegistrationServlet;

import javax.servlet.ServletException;
import java.sql.SQLException;

/**
 * Created by mikhail on 28/12/16.
 */
public class AuthService  {
    private static Logger log = Logger.getLogger(RegistrationServlet.class.getName());
    public static boolean checkAuth(String email, String password) {

        UsersDao usersDao = new UsersDaoImpl();
        String user_pass = null;
        try {
            user_pass = usersDao.getAuth(email);
        } catch (DataException e) {
            e.printStackTrace();
        }
        log.info("pass and pass "  + user_pass + " " + password );
        if (password.equals(user_pass)){
            return true;
        }
        else{
            return false;
        }
    }

//    @Nullable
    public static Users getUserbyEmail(String email) throws  ServiceException {

        UsersDao usersDao = new UsersDaoImpl();

        try {
            return usersDao.getUserByEmail(email);
        } catch (DataException e) {
            ServiceException a = new AuthServiceException("service exception", e);
            throw a;
        }
    }

    public static Boolean isAdmin(String email) throws ServiceException {
        UsersDao usersDao = new UsersDaoImpl();
        try{
            return usersDao.getAdmin(email);
        } catch (DataException e) {
            ServiceException b = new ServiceException("service exception", e);
            throw b;
        }
    }
}
