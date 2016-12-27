package ru.inno.training;

import java.sql.*;
import java.util.concurrent.locks.Lock;

/**
 * Created by mikhail on 25/12/16.
 */
public class DBManagerPSQLimpl implements DBManager {
    private static volatile Connection connection;

    private static Connection createConnection() {
        try {

            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Training";
            String login = "postgres";
            String password = "Termipt91";
            Connection con = DriverManager.getConnection(url, login, password);

            return con;


        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;


    }

    public Connection getConnection() {
        if (connection == null) {
            connection = createConnection();

        }

    return connection;

    }

}



