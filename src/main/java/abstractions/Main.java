package abstractions;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {



	public static void main(String[] args) {

		// create group
		GroupDao groupDao = new GroupDao();
		Group g = new Group("sample name");
		//save group to database
		groupDao.save(g);

		//get all groups
		List<Group> groups = groupDao.loadAll();
		for (Group group : groups) {
			System.out.println(group);
		}
		//update group
		g.setName("other name");
		groupDao.save(g);
		
		//remove group
		Group firstElement = groupDao.loadById(1);
		System.out.println(firstElement);
		if (firstElement != null) {
			groupDao.delete(firstElement);
		}
	}

    static {
        try(Connection connection = DriverManager.getConnection("jdbc:h2:file:./data/sample");
            Statement statement = connection.createStatement();) {
            String sql = IOUtils.toString(Main.class.getResourceAsStream("/dump.sql"));
            boolean execute = statement.execute(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
