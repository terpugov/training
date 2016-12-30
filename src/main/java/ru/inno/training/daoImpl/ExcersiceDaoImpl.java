package ru.inno.training.daoImpl;

import org.apache.log4j.Logger;
import ru.inno.training.DBManager;
import ru.inno.training.DBManagerPSQLimpl;
import ru.inno.training.dao.ExcerciseDao;
import ru.inno.training.pojo.Excercise;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mikhail on 24/12/16.
 */
public class ExcersiceDaoImpl implements ExcerciseDao {
    private static Logger log = Logger.getLogger(UsersDaoImpl.class.getName());
    private DBManager db = new DBManagerPSQLimpl();
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
/*    public void deleteExcercise(Excercise excercise);
    public void updateExcercise(Excercise excercise);*/

}
