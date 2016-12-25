package ru.inno.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by mikhail on 25/12/16.
 */
public class DBConnection {

    public static void connection(){
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Training";
            String login = "postgres";
            String password = "Termipt91";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs =stmt.executeQuery("select * from users");
                stmt.executeUpdate("INSERT INTO users (user_name, user_surname, user_email, admin ) VALUES('Ilmira', 'Terpugova', 'ia@gmail.com', 'FALSE' , 1234)");
                while (rs.next()) {
                    String str = rs.getString("user_id");
                    System.out.println("Contact:" + str);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        DBConnection.connection();
    }
}

