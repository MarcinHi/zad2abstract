package zad2.exercise;

import org.apache.commons.io.IOUtils;
import zad2.Main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {
    static {
        try(Connection connection = DriverManager.getConnection("jdbc:h2:file:./data/sample");
            Statement statement = connection.createStatement();) {
            String sql = IOUtils.toString(Main.class.getResourceAsStream("dump.sql"));
            System.out.println(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExerciseDao exerciseDao = new ExerciseDao();
        Exercise exercise1 = new Exercise("Some titile1", "Some descriptoin1");
        Exercise exercise2 = new Exercise("Some titile2", "Some descriptoin2");
        Exercise exercise3 = new Exercise("Some titile3", "Some descriptoin3");
        exerciseDao.save(exercise1);
        exerciseDao.save(exercise2);
        exerciseDao.save(exercise3);

        for (Exercise exercise : exerciseDao.loadAll()) {
            System.out.println(exercise);
            exerciseDao.delete(exercise);
        }



    }
}
