package examSystem;
import java.sql.*;

import javax.swing.JOptionPane;


public class dbConnection {
	Connection con;
	PreparedStatement ps;
	ResultSet rs = null;
	public dbConnection(){
		try {
			String url = "jdbc:mysql://localhost:3306/db_examsystem";
			String userName="root";
			String password="";
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,userName,password);
	        
		} catch (Exception e) {
		}
		
	}
	public void executeQuery(String query)  //insert,update,delete
    {
        try {
            ps=con.prepareStatement(query);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);;
        }
        
         
     }
	public ResultSet fetchingData(String query) {
		try {
			ps=con.prepareStatement(query);
			rs= ps.executeQuery();
			//rs.next();	
			} catch (Exception e) {
			// TODO: handle exception
				
		}
		return rs;
	}
            
        
    
}
