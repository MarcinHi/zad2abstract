package zad2.exercise;


import zad2.AbstractDao;
import zad2.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExerciseDao extends AbstractDao<Exercise> {

    private static final String LOAD_ALL_QUERY = "SELECT * FROM exercise;";
    private static final String LOAD_BY_ID_QUERY = "SELECT * FROM exercise WHERE id=?;";
    private static final String CREATE_QUERY = "INSERT INTO exercise(title, description) VALUES(?,?);";
    private static final String UPDATE_QUERY = "UPDATE exercise SET title=?, description=? WHERE id=?;";
    private static final String DELETE_QUERY = "DELETE FROM exercise WHERE id=?;";

    @Override
    protected PreparedStatement saveNewStatement(Connection con, Exercise exercise) throws SQLException {
        String[] generatedColumns = { "id" };
        PreparedStatement ps = con.prepareStatement(CREATE_QUERY, generatedColumns);
        ps.setString(1,  exercise.getTitle());
        ps.setString(2,  exercise.getDescription());
        return ps;

    }

    @Override
    protected PreparedStatement updateExistingStatement(Connection con, Exercise exercise) throws SQLException {
        PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
        ps.setString(1,  exercise.getTitle());
        ps.setString(2,  exercise.getDescription());
        ps.setLong(3, exercise.getId());
        return ps;
    }

    @Override
    protected PreparedStatement deleteStatement(Connection con, Exercise exercise) throws SQLException {
        PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
        ps.setLong(1, exercise.getId());
        return ps;

    }

    @Override
    protected Exercise newFromResultSet(ResultSet rs) throws SQLException {
        return new Exercise(rs.getLong("id"), rs.getString("title"),rs.getString("description"));
    }

    @Override
    protected String getLoadAllQuery() {
        return LOAD_ALL_QUERY;
    }

    @Override
    protected String getLoadByIdQuery() {
        return LOAD_BY_ID_QUERY;
    }
}
