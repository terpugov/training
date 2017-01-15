package ru.inno.training.daoImpl;

import org.apache.log4j.Logger;
import ru.inno.training.dao.exceptions.DataException;
import ru.inno.training.daoImpl.exceptions.ExcersiceDataException;
import ru.inno.training.daoImpl.exceptions.UserDataException;
import ru.inno.training.db.DBManager;
import ru.inno.training.db.DBManagerPSQLimpl;
import ru.inno.training.dao.ExcerciseDao;
import ru.inno.training.pojo.Excercise;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mikhail on 24/12/16.
 */
public class ExcersiceDaoImpl implements ExcerciseDao {
    private static Logger log = Logger.getLogger(ExcersiceDaoImpl.class.getName());
    private static DBManager db = new DBManagerPSQLimpl();
//    private Connection curConnection = db.getConnection();

/*    public Excercise readExcersise(){}
    public List<Excercise> readExcercise();*/
    public List<Excercise> readExcercise() throws DataException {
        Connection conn;
        List<Excercise> excercises = new LinkedList<>();

        try {
            log.debug("readExcercise");
            conn = DBManagerPSQLimpl.getDs().getConnection();
            log.debug("readExcercise conn = " + conn.hashCode());
            Statement stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery("Select * from excercise");
            int count = 0;
            while (rst.next()) {
                Excercise excercise = new Excercise();
                excercise.setName(rst.getString("excercise_name"));
                excercise.setDescription(rst.getString("excercise_description"));
                excercise.setExcerciseComplexity(rst.getString("excercise_complexity"));
                excercise.setExcerciseType(rst.getString("excercise_type"));
                excercises.add(excercise);
//                log.debug("UsersDaoImpl{}" + rst.getString("user_id") + rst.getString("user_name"));
            }
            conn.close();
        } catch (SQLException e) {
            DataException a = new ExcersiceDataException("Excercise data error", e);
            a.printStackTrace();
            throw a;
        }

        return excercises;

    }

    @Override
    public void deleteExcercise(Excercise excercise) throws DataException {

        try {

            Connection conn = DBManagerPSQLimpl.getDs().getConnection();
            PreparedStatement prpStm = null;
            ResultSet resultSet;
            conn.close();
        } catch (SQLException e) {
            DataException a = new ExcersiceDataException("Excercise data error", e);
            a.printStackTrace();
            throw a;

        }


    }

    @Override
    public void addExcercise(String name, String description, String complexity, String type) {

        PreparedStatement prpStm = null;
        ResultSet resultSet;

        try {
            log.debug("addExcercise");
            Connection conn = DBManagerPSQLimpl.getDs().getConnection();
            log.debug("addExcercise  conn = " + conn.hashCode());
            prpStm = conn.prepareStatement("insert into excercise (excercise_name, excercise_description, excercise_complexity, excercise_type) values(?,?,?,?)");
            prpStm.setString(1, name);
            prpStm.setString(2, description);
            prpStm.setString(3, complexity);
            prpStm.setString(4, type);
            prpStm.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            DataException a = new ExcersiceDataException("Excercise data error", e);
            e.printStackTrace();
        }


    }
/*    public void deleteExcercise(Excercise excercise);
    public void updateExcercise(Excercise excercise);*/

}
