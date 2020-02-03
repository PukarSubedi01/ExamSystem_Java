package examSystem;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class validation {
	String query;
	dbConnection dbc = new dbConnection();
	examSystem es = new examSystem();
	
	public Boolean regValidation(String Fname, String Lname, String email, String password)
	{
		if (Fname.isEmpty() || Lname.isEmpty() || email.isEmpty() || password.isEmpty())
		{
			
			return false;
		} 
		else
		{
			
			
			//String pswStr = new String(signupPsw.getPassword());
			query = "insert into examinees values('"+ Fname + "','"+ Lname +"','"+email+ "','"+password+"'"+")";
			dbc.executeQuery(query);
			JOptionPane.showMessageDialog(null, "Account successfully created");
			return true;
					
		}
	}
	public Boolean loginValidation(String email, String password) throws HeadlessException, SQLException {
		query= "select Email,password from examinees where Email='"+email+"'";
		ResultSet rs = dbc.fetchingData(query);
		
			if (rs.next()) {
				if (email.equals(rs.getString("Email")) && password.equals(rs.getString("Password"))) {
					return true;
					//JOptionPane.showMessageDialog(null, "valid login");
					
				}
				
				else
				{
					
					return false;
				}
			}
			else {
				return false;
				
				
			}
			
		
		
	}
	public Boolean adminLogVal(String username, String password) throws SQLException {
		query= "select username,password from administration where username='"+username+"'";
		ResultSet rs = dbc.fetchingData(query);
		
			if (rs.next()) {
				if (username.equals(rs.getString("username")) && password.equals(rs.getString("Password"))) {
					//JOptionPane.showMessageDialog(null, "valid login");
					return true;
				}
				
				else
				{
					//JOptionPane.showMessageDialog(null, "invalid username or password");
					return false;
				}
			}
			else {
				//JOptionPane.showMessageDialog(null, "invalid username or password");
				return false;
			}
	}
	public Boolean javaQuestionInsertion(String question,String opt1,String opt2,String opt3,String opt4,String ans) {
		if (question.isEmpty() || opt1.isEmpty()||opt2.isEmpty()||opt3.isEmpty()||opt4.isEmpty()||ans.isEmpty()) {
			return false;
			
		} 
		else {
			query = "insert into java_question values('"+0+"','"+ question + "','"+opt1 +"','"+opt2+ "','"+opt3+"','"+opt4+"','"+ans+"')";
			dbc.executeQuery(query);
			return true;
		}
		
	}
	public Boolean cQuestionInsertion(String question,String opt1,String opt2,String opt3,String opt4,String ans) {
		if (question.isEmpty() || opt1.isEmpty()||opt2.isEmpty()||opt3.isEmpty()||opt4.isEmpty()||ans.isEmpty()) {
			return false;
		} 
		else {
			query = "insert into c_question values('"+0+"','"+ question + "','"+opt1 +"','"+opt2+ "','"+opt3+"','"+opt4+"','"+ans+"')";
			dbc.executeQuery(query);
			return true;
			
		}
		
	}
	public Boolean pythonQuestionInsertion(String question,String opt1,String opt2,String opt3,String opt4,String ans) {
		if (question.isEmpty() || opt1.isEmpty()||opt2.isEmpty()||opt3.isEmpty()||opt4.isEmpty()||ans.isEmpty()) {
			return false;
		} 
		else {
			query = "insert into python_question values('"+0+"','"+ question + "','"+opt1 +"','"+opt2+ "','"+opt3+"','"+opt4+"','"+ans+"')";
			dbc.executeQuery(query);
			return true;
			
		}
		
	}
	public Boolean javascriptQuestionInsertion(String question,String opt1,String opt2,String opt3,String opt4,String ans) {
		if (question.isEmpty() || opt1.isEmpty()||opt2.isEmpty()||opt3.isEmpty()||opt4.isEmpty()||ans.isEmpty()) {
			return false;
		} 
		else {
			query = "insert into javascript_question values('"+0+"','"+ question + "','"+opt1 +"','"+opt2+ "','"+opt3+"','"+opt4+"','"+ans+"')";
			dbc.executeQuery(query);
			return true;
			
		}
		
	}
}
