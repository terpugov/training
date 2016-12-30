package ru.inno.training.service;

import ru.inno.training.pojo.Users;
import ru.inno.training.daoImpl.UsersDaoImpl;
import ru.inno.training.dao.UsersDao;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public Users createInstanceUser(String userName, String userSurname, String userEmail, String userPassword, String session, boolean userAdmin){
        Users user = new Users(userName, userSurname, userEmail, userPassword,  userAdmin);
        user.setSession(session);
        return user;
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
    public static boolean validateEmail(String email){

        Pattern checkAt = Pattern.compile("^[^@]+@[^@]+$");
        Pattern checkName = Pattern.compile("^[a-z0-9\\\".!,;_-]{1,128}@");
        Pattern checkQuote = Pattern.compile("^[^\"!,;]*(\"[^\"]*?\"[^\"!,;]*?)*$");
        Pattern checkDomain = Pattern.compile("@((?!-)[a-z0-9_-]+(?<!-)\\.)+((?!-)[a-zA-Z0-9_-]+(?<!-))$");
        Pattern checkDots = Pattern.compile("(\\.\\.)");
        Matcher cAt = checkAt.matcher(email);


//        Matcher cD  = checkDomain.matcher(email);


        if (cAt.find()) {
            String email1 = cAt.group();
            Matcher cN = checkName.matcher(email1);
            if (cN.find()) {
                String email2 = cN.group();
                System.out.println(email2);
                Matcher cQ = checkQuote.matcher(email2.substring(0, email2.length() - 1));
                if (cQ.find()) {
                    String email3 = cQ.group();
                    System.out.println(email3);
                    Matcher cDts = checkDots.matcher(email3);
                    if (!cDts.find()) {

                        System.out.println(email3);
                        Matcher cD = checkDomain.matcher(email1);
                        if (cD.find()) {
                            String email4 = cD.group();
                            System.out.println(email4);
                            return true;
                    }
                    }
                }
            }
        }


        return false;
    }

    public static void main(String[] args) {
        System.out.println(validateEmail("mtugov@gmail.com"));
    }
}
