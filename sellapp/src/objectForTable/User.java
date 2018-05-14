package objectForTable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hibernate.DB_Operate;
import hibernate.JDBCUtils;

public class User {
	private long id;
//	private int Permit;
//	private String UserName;
//	private String Password;
//	public long getID() {
//		return ID;
//	}
//	public void setID(int iD) {
//		ID = iD;
//	}
	public User(){
		super();
	}
	public User(long id){
		this.id=id;
	}
//	public int getPermit() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
//		DB_Operate dboperate = new JDBCUtils();
//		List list = new ArrayList();
//		list.add(id);
//	   return (int) dboperate.execToList("select * from sell_user where ID = ?",list).getRow(0).getColValue("Permit");
//	}
//	public void setPermit(int permit) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
//		DB_Operate dboperate = new JDBCUtils();
//		List list = new ArrayList();
//		list.add(permit);
//		list.add(id);
//		String sql="update sell_user set Permit=? where ID =?";
//		dboperate.update(sql, list);
//	}
	public String getUserName() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (String) dboperate.execToList("select * from sell_user where ID = ?",list).getRow(0).getColValue("UserName");
	}
	public void setUserName(String userName) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(userName);
		list.add(id);
		String sql="update sell_user set UserName=? where ID =?";
		dboperate.update(sql, list);
	}
	public String getPassword() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (String) dboperate.execToList("select * from sell_user where ID = ?",list).getRow(0).getColValue("Password");
	}
	public void setPassword(String password) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(password);
		list.add(id);
		String sql="update sell_user set Password=? where ID =?";
		dboperate.update(sql, list);
	}
	public String getAvatar() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (String) dboperate.execToList("select * from sell_user where ID = ?",list).getRow(0).getColValue("Avatar");
	}
	public void setAvatar(String avatar) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(avatar);
		list.add(id);
		String sql="update sell_user set Avatar=? where ID =?";
		dboperate.update(sql, list);
	}
	public String getNickname() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (String) dboperate.execToList("select * from sell_user where ID = ?",list).getRow(0).getColValue("Nickname");
	}
	public void setNickname(String nickname) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(nickname);
		list.add(id);
		String sql="update sell_user set Nickname=? where ID =?";
		dboperate.update(sql, list);
	}
	public String getCreateTime() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (String) dboperate.execToList("select * from sell_user where ID = ?",list).getRow(0).getColValue("CreateTime");
	}
	public void setCreateTime(String createTime) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(createTime);
		list.add(id);
		String sql="update sell_user set CreateTime=? where ID =?";
		dboperate.update(sql, list);
	}
	public String getTelephone() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (String) dboperate.execToList("select * from sell_user where ID = ?",list).getRow(0).getColValue("Telephone");
	}
	public void setTelephone(String telephone) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(telephone);
		list.add(id);
		String sql="update sell_user set Telephone=? where ID =?";
		dboperate.update(sql, list);
	}
	
}
