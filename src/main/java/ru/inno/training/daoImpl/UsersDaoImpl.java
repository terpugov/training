package ru.inno.training.daoImpl;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import ru.inno.training.DBManager;
import ru.inno.training.DBManagerPSQLimpl;
import ru.inno.training.dao.UsersDao;
import ru.inno.training.pojo.Users;

/**
 * Created by mikhail on 24/12/16.
 */
public class UsersDaoImpl implements UsersDao {
    private static Logger log = Logger.getLogger(UsersDaoImpl.class.getName());
    private DBManager db = new DBManagerPSQLimpl();
    Connection curConnection = db.getConnection();


/*
    public void someMethod() {
        log.info("Some message");
    }*/

    public List<Users> readUsers() throws SQLException {

        List<Users> users = new LinkedList<>();
        try {
            Statement stmt = curConnection.createStatement();
            ResultSet rst = stmt.executeQuery("Select * from users");
            int count = 0;
            while (rst.next()) {
                String name = rst.getString("user_email");
                String surname = rst.getString("user_surname");
                String email = rst.getString("user_email");
                int id = rst.getInt("user_id");
                String password = rst.getString("user_password");
                boolean admin = rst.getBoolean("user_admin");


                Users user = new Users(name, surname, email, password, admin);
                user.setUserName(rst.getString("user_name"));
                user.setUserSurname(rst.getString("user_surname"));
                user.setUserEmail(rst.getString("user_email"));
                user.setId(rst.getInt("user_id"));
                users.add(user);
//                log.debug("UsersDaoImpl{}" + rst.getString("user_id") + rst.getString("user_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void createUser(String name, String surname, String email, boolean admin, String password) {

        try {

            log.info("UserDaoImpl{}" + curConnection);
            PreparedStatement preparedStatement = curConnection.prepareStatement("Insert into users (user_name, user_surname, user_email, user_admin, user_password) values (?, ?, ?, ?, ?)");
            log.info("UserDaoImpl{}" + preparedStatement);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, email);
            preparedStatement.setBoolean(4, admin);
            preparedStatement.setString(5, password);
            log.info("UserDaoImpl{}" + surname);
            preparedStatement.executeUpdate();
//            log.debug("preparedStatement" +  preparedStatement.executeUpdate());

        } catch (SQLException e) {
            e.printStackTrace();
        }



 /*   @Override
    public void deleteUser(int id) {
            Statement statement =

    }

    @Override
    public void updateUser(Object excercise) {

    }
*}*/

    }

    @Override
    public String getAuth(String email) {

        try {
            log.debug("I am in getAuth");
            ResultSet resultSet;
            PreparedStatement preparedStatement = curConnection.prepareStatement("select user_password from users where user_email = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String result = resultSet.getString(1);
            log.debug("resultSet and result" + result + " " + resultSet);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Users getUserByEmail(String email) {
        ResultSet resultSet;
        Users user;
        try {
            PreparedStatement preparedStatement = curConnection.prepareStatement(" select * from users where user_email = ?");
            preparedStatement.setString(1, email);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String userName = resultSet.getString(1);
            String userSurname = resultSet.getString(2);
            String userEmail = resultSet.getString(3);
            String userPassword = resultSet.getString(4);
            boolean userAdmin = resultSet.getBoolean(5);

            user = new Users(userName, userSurname, userEmail, userPassword, userAdmin);
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean getAdmin(String email) {
        ResultSet resultSet;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = curConnection.prepareStatement(" select user_admin from users where user_email = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Boolean result = resultSet.getBoolean(1);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }



        return false;
    }
}
