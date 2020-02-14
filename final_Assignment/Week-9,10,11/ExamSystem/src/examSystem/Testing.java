package examSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class Testing {

	@Test
	void RegValidationTest() {
		validation v =new validation();
		Boolean result=v.regValidation("", "", "", "");
		assertEquals(false, result);
	}
	@Test
	void QdelValidationTest() {
		validation v =new validation();
		Boolean result=v.javaQuestionDel(0);
		assertEquals(false, result);
	}
	@Test
	void adminLoginValidationTest() throws SQLException {
		validation v =new validation();
		Boolean result=v.adminLogVal("admin", "admin");
		assertEquals(true, result);
	}
	@Test
	void QinsValidationTest() {
		validation v =new validation();
		Boolean result=v.javaQuestionInsertion("", "", "", "", "", "");
		assertEquals(false, result);
	}
	@Test
	void QupdateValidationTest() {
		validation v =new validation();
		Boolean result=v.javaQuestionUpdate("", "", "", "", "", "", 0);
		assertEquals(false, result);
	}
}
