package abstractions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupDao extends AbstractDao<Group> {

	private static final String LOAD_ALL_QUERY = "SELECT * FROM user_group;";
	private static final String LOAD_BY_ID_QUERY = "SELECT * FROM user_group WHERE id=?;";
	private static final String CREATE_QUERY = "INSERT INTO user_group(port) VALUES(?);";
	private static final String UPDATE_QUERY = "UPDATE user_group SET port=? WHERE id=?;";
	private static final String DELETE_QUERY = "DELETE FROM user_group WHERE id=?;";

	@Override
	protected PreparedStatement saveNewStatement(Connection con, Group group) throws SQLException {
		String[] genereatedColumns = { "id" };
		PreparedStatement ps = con.prepareStatement(CREATE_QUERY, genereatedColumns);
		ps.setString(1,  group.getName());
		return ps;

	}

	@Override
	protected PreparedStatement updateExistingStatement(Connection con, Group group) throws SQLException {
		PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
		ps.setString(1,  group.getName());
		ps.setLong(2, group.getId());
		return ps;
	}

	@Override
	protected PreparedStatement deleteStatement(Connection con, Group group) throws SQLException {
		PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
		ps.setLong(1, group.getId());
		return ps;

	}

	@Override
	protected Group newFromResultSet(ResultSet rs) throws SQLException {
		return new Group(rs.getLong("id"), rs.getString("port"));
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
