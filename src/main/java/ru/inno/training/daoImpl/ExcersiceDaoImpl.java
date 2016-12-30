package ru.inno.training.daoImpl;

import org.apache.log4j.Logger;
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
    private static Logger log = Logger.getLogger(UsersDaoImpl.class.getName());
    private static DBManager db = new DBManagerPSQLimpl();
//    private Connection curConnection = db.getConnection();

/*    public Excercise readExcersise(){}
    public List<Excercise> readExcercise();*/
    public List<Excercise> readExcercise(){
        Connection curConnection = db.getConnection();
        List<Excercise> excercises = new LinkedList<>();
        try {
            Statement stmt = curConnection.createStatement();
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

        } catch (SQLException e) {
            e.printStackTrace();
        } /*finally {
            try {
                curConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }*/
        return excercises;

    }

    @Override
    public void deleteExcercise(Excercise excercise) {
        Connection curConnection = db.getConnection();
        PreparedStatement prpStm = null;
        ResultSet resultSet;

    }

    @Override
    public void addExcercise(String name, String description, String complexity, String type) {
        Connection curConnection = db.getConnection();
        PreparedStatement prpStm = null;
        ResultSet resultSet;

        try {
            prpStm = curConnection.prepareStatement("insert into excercise (excercise_name, excercise_description, excercise_complexity, excercise_type) values(?,?,?,?)");
            prpStm.setString(1, name);
            prpStm.setString(2, description);
            prpStm.setString(3, complexity);
            prpStm.setString(4, type);
            prpStm.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
/*    public void deleteExcercise(Excercise excercise);
    public void updateExcercise(Excercise excercise);*/

}
