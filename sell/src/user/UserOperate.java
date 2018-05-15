package user;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import hibernate.DB_Operate;
import hibernate.JDBCUtils;
import objectForTable.User;


public class UserOperate {
	private HttpServletRequest request;
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public User getUserInfoByID(int id){
		User user=new User(id);
		return user;
	}

	public UserOperate (){
		
	}
	public int getUserId(String username) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		DB_Operate db_operate=new JDBCUtils();
		String sql="select * from sell_user where UserName =?";
		List list=new ArrayList();
		list.add(username);
		int id=(int) db_operate.execToList(sql, list).getRow(0).getColValue("ID");
		
		return id;
	}

	public boolean userIsMatch(String username,String password) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException, NoSuchAlgorithmException{
		String sql="select * from sell_user where UserName =?";
				DB_Operate dboperate = new JDBCUtils();
				List list=new ArrayList();
				list.add(username);
	    String psswd=(String) dboperate.execToList(sql,list).getRow(0).getColValue("Password");
	    
	    if(psswd.equals(password))
		return true;
	    return false;
	
	}
	public boolean userRegister(String un,String p,String n,String t,long createTime) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException, NoSuchAlgorithmException{
		boolean b=false;
		String sql="select * from sell_user where UserName = ?";//�û���Ψһ������û����Ƿ�����
//		String sqlAdmin="insert into sell_user(UserName,Password,Permit) values(un,p,1)";
		String sqlUser="insert into sell_user(UserName,Password,Nickname,Telephone,Createtime)values(?,?,?,?,?)";
		DB_Operate dboperate = new JDBCUtils();
		
		List list1=new ArrayList();
		list1.add(un);
		List list=new ArrayList();
		list.add(un);
		list.add(p);
		list.add(n);
		list.add(t);
		list.add(createTime);
		
		if(dboperate.execToList(sql,list1).getDataList().size()==0){
//			 int temp=dboperate.insert(sqlAdmin);
			 int temp1=dboperate.insert(sqlUser,list);
			 addCart(un);
			 System.out.println("ע��ɹ�");
			 b=true;
		}
		return b;	
	}
	public boolean userLogout(){
		boolean b=false;
		request.getSession().removeAttribute("userID");
		request.getSession().setAttribute("login", false);
		return b;	
	}
	public boolean isLogin(){
		boolean b=false;
		if(request.getSession().getAttribute("username")!=null){
			b=true;
		}
		return b;
	}
	public void addCart(String userID) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		String sqlInsert = "insert into sell_cart(UserID) values(?)";
		ArrayList listInsert = new ArrayList<>();
		listInsert.add(userID);
		DB_Operate db_operate=new JDBCUtils();
		db_operate.insert(sqlInsert, listInsert);
	}
	public static void main(String [] args) throws ClassNotFoundException, FileNotFoundException, NoSuchAlgorithmException, SQLException, IOException{
		UserOperate userOperate = new UserOperate();
		System.out.println(userOperate.userIsMatch("mailian", "12456"));
		userOperate.userRegister("lian", "789", "mai", "12345678",1234);
		
	}
}
