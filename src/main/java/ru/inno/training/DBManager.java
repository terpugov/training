package ru.inno.training;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by mikhail on 25/12/16.
 */
public interface DBManager {

    public Connection getConnection();

}
