package entity;

public class User {
	private long ID;
	private int Permit;
	private String UserName;
	private String Password;
	public long getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getPermit() {
		return Permit;
	}
	public void setPermit(int permit) {
		Permit = permit;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
