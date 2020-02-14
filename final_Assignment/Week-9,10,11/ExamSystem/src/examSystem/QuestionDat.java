package examSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionDat {
public ArrayList<QandA> javaQuestionData() throws SQLException{
	ArrayList<QandA> javaQuestionnaire = new ArrayList<QandA>();
	String query="Select * from java_question";
	dbConnection dbc = new dbConnection();
	ResultSet rs = dbc.fetchingData(query);
	QandA qa;
	while (rs.next()) {
		qa = new QandA(rs.getInt("Id"),rs.getString("question"), rs.getString("option1"), rs.getString("option2"), 
				rs.getString("option3"), rs.getString("option4"), rs.getString("answer"));
		javaQuestionnaire.add(qa);
	}
	return javaQuestionnaire;
}
public ArrayList<QandA> pythonQuestionData() throws SQLException{
	ArrayList<QandA> pythonQuestionnaire = new ArrayList<QandA>();
	String query="Select * from python_question";
	dbConnection dbc = new dbConnection();
	ResultSet rs = dbc.fetchingData(query);
	QandA qa;
	while (rs.next()) {
		qa = new QandA(rs.getInt("Id"),rs.getString("question"), rs.getString("option1"), rs.getString("option2"), 
				rs.getString("option3"), rs.getString("option4"), rs.getString("answer"));
		pythonQuestionnaire.add(qa);
	}
	return pythonQuestionnaire;
}
public ArrayList<QandA> cSharpQuestionData() throws SQLException{
	ArrayList<QandA> cSharpQuestionnaire = new ArrayList<QandA>();
	String query="Select * from c_question";
	dbConnection dbc = new dbConnection();
	ResultSet rs = dbc.fetchingData(query);
	QandA qa;
	while (rs.next()) {
		qa = new QandA(rs.getInt("Id"),rs.getString("question"), rs.getString("option1"), rs.getString("option2"), 
				rs.getString("option3"), rs.getString("option4"), rs.getString("answer"));
		cSharpQuestionnaire.add(qa);
	}
	return cSharpQuestionnaire;
}
public ArrayList<QandA> jsQuestionData() throws SQLException{
	ArrayList<QandA> jsQuestionnaire = new ArrayList<QandA>();
	String query="Select * from javascript_question";
	dbConnection dbc = new dbConnection();
	ResultSet rs = dbc.fetchingData(query);
	QandA qa;
	while (rs.next()) {
		qa = new QandA(rs.getInt("Id"),rs.getString("question"), rs.getString("option1"), rs.getString("option2"), 
				rs.getString("option3"), rs.getString("option4"), rs.getString("answer"));
		jsQuestionnaire.add(qa);
	}
	return jsQuestionnaire;
}
}
