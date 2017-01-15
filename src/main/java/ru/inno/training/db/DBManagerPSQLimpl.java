package ru.inno.training.db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

/**
 * Created by mikhail on 25/12/16.
 */
public class DBManagerPSQLimpl implements DBManager {
//    private static volatile Connection connection;
    public static DataSource ds;

    static{

        InitialContext initContext= null;
        try {

            InitialContext cxt = new InitialContext();
            if ( cxt == null ) {
                throw new Exception("Uh oh -- no context!");
            }

            ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/postgres" );


            if ( ds == null ) {
                throw new Exception("Data source not found!");
            }
            Connection conn = ds.getConnection();

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static DataSource getDs() {
        return ds;
    }

/*    private static Connection createConnection() {
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
    }*/


}



