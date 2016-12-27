package ru.inno.training;

import org.apache.catalina.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mikhail on 24/12/16.
 */
public class UsersDaoImpl implements UsersDao {
    private static Logger log = Logger.getLogger(UsersDaoImpl.class.getName());
    private DBManagerPSQLimpl db = new DBManagerPSQLimpl();
    Connection curConnection = db.getConnection();



    public void someMethod() {
        log.info("Some message");
    }

    public List<Users> readUsers() throws SQLException {

        List<Users> users = new LinkedList<>();
        try {
            Statement stmt = curConnection.createStatement();
            ResultSet rst = stmt.executeQuery("Select * from users");
            int count = 0;
            while (rst.next()) {
                Users user = new Users();
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
}
