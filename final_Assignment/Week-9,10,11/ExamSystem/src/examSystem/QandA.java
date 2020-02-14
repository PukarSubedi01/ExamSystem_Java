package examSystem;

public class QandA {
private String questions,option1,option2,option3,option4,correctAns;
private int qId;
public QandA(int qId,String questions,String option1,String option2,String option3,String option4,String correctAns) {
	this.qId = qId;
	this.questions=questions;
	this.option1 = option1;
	this.option2 = option2;
	this.option3 = option3;
	this.option4 = option4;
	this.correctAns = correctAns;
	}
public int getQid() {
	return qId;
}
public String getQuestion() {
	return questions;
}
public String getOption1() {
	return option1;
}
public String getOption2() {
	return option2;
}
public String getOption3() {
	return option3;
}
public String getOption4() {
	return option4;
}
public String getCorrectAns() {
	return correctAns;
}
}
