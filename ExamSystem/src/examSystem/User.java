package examSystem;
public class User {
	private String FirstName,LastName,Email;
	
	public User(String FirstName,String LastName,String Email) {
		this.FirstName=FirstName;
		this.LastName = LastName;
		this.Email = Email;
	}
	public String getFname() {
		return FirstName;
	}
	public String getLastName() {
		return LastName;
		
	}
	public String getEmail() 
	{
		return Email;
	}
}
