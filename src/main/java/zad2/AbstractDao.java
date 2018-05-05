package zad2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T extends Model> implements DaoInterface<T> {

	protected abstract T newFromResultSet(ResultSet rs) throws SQLException;

	protected abstract String getLoadAllQuery();

	protected abstract String getLoadByIdQuery();

	protected abstract PreparedStatement saveNewStatement(Connection con, T item) throws SQLException;

	protected abstract PreparedStatement updateExistingStatement(Connection con, T item) throws SQLException;

	protected abstract PreparedStatement deleteStatement(Connection con, T item) throws SQLException;

	@Override
	public List<T> loadAll() {
		List<T> list = new ArrayList<>();
		try (Connection con = DbUtil.getConnection()) {
			try (ResultSet rs = con.prepareStatement(getLoadAllQuery()).executeQuery()) {
				while (rs.next()) {
					list.add(newFromResultSet(rs));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public T loadById(int id) {
		try (Connection con = DbUtil.getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(getLoadByIdQuery())) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					return newFromResultSet(rs);
				}
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void save(T item) {
		try (Connection con = DbUtil.getConnection()) {
			if (item.getId() == null) {
				saveNewToDb(con, item);
			} else {
				updateExistingInDb(con, item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void delete(T item) {
		try (Connection con = DbUtil.getConnection()) {
			if (item.getId() != 0) {
				try (PreparedStatement ps = deleteStatement(con, item)) {
					ps.executeUpdate();
				}
				item.setId(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void saveNewToDb(Connection con, T item) throws SQLException {
		try (PreparedStatement ps = saveNewStatement(con, item)) {
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				item.setId(rs.getInt(1));
			}
			rs.close();
		}
	}

	private void updateExistingInDb(Connection con, T item) throws SQLException {
		try (PreparedStatement ps = updateExistingStatement(con, item)) {
			ps.executeUpdate();
		}
	}

}
