package examSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExamineesDat{
	public ArrayList<User> tableData() throws SQLException {
	ArrayList<User> tableData= new ArrayList<User>();
	String query="Select FirstName,LastName,Email from examinees";
	dbConnection dbc = new dbConnection();
	ResultSet rs = dbc.fetchingData(query);
	User user;
	while (rs.next()) {
		user = new User(rs.getString("FirstName"),rs.getString("LastName"), rs.getString("Email"));
		tableData.add(user);
		
	}
	return tableData;
	}
	
}

