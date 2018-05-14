package dao.impl;



import java.io.Serializable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import domain.User;
import utils.DBUtils;



public class UserDaoImpl implements UserDao{

	@Override
	public User getUserByUAndP(String username, String password) {
		/**拼写sql语句，查询用户表，提取相关登录信息*/
		String SQL = "SELECT *" +
		" FROM " +
		" S_User u" +
		" WHERE " +
		" u.username = ? AND u.password = ?";
		
		DBUtils dbc = null;
		PreparedStatement pstm=null;
		dbc = new DBUtils();
		User userInfo = null;
		try
		{
		   pstm = dbc.getConnection().prepareStatement(SQL);
		   pstm.setString(1,username.trim());
		   pstm.setString(2,password);
		   ResultSet rs = pstm.executeQuery();
		   if (rs.next())//用户名和密码存在
		   {
			    userInfo = new User();
		   }
		   rs.close();
		   pstm.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
			try {
				throw new Exception("连接数据库出错!");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally 
		{
			dbc.close();
		}
		//如果用户名和密码存在，则返回一个对象，如果不存在，则返回一个null
		return userInfo;
	}

	@Override
	public List<User> getAllUser() {
		List<User> all = new ArrayList<User>();
		String sql = "SELECT *" +
		" FROM " +
		" S_User u";
		
		PreparedStatement pstmt = null;
		DBUtils dbc = null;
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DBUtils();
			pstmt = dbc.getConnection().prepareStatement(sql);
			// 进行数据库查询操作
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserID(rs.getLong("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));/**性别*/
				user.setBirthday(rs.getDate("birthday"));/**出生日期*/
				user.setEducation(rs.getString("education"));/**学历*/
				user.setTelephone(rs.getString("telephone"));/**电话*/
				user.setInterest(rs.getString("interest"));/**兴趣爱好*/
				user.setPath(rs.getString("path"));/**简历文件路径*/
				user.setFilename(rs.getString("filename"));/**简历文件名*/
				user.setRemark(rs.getString("remark"));/**备注*/
				// 将查询出来的数据加入到List对象之中
				all.add(user);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			try {
				throw new Exception("操作出现异常");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		return all;
	}

	@Override
	public User getUserById(Serializable uid) {
		User user = null;
		/**拼写sql语句，*/
		String sql = "SELECT *" +
				" FROM " +
				" S_User u" +
				" WHERE " +
				" u.userID=?";
		PreparedStatement pstmt = null;
		DBUtils dbc = null;
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DBUtils();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(uid.toString()));
			// 进行数据库查询操作
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// 查询出内容，之后将查询出的内容赋值给User对象
				user = new User();
				user.setUserID(rs.getLong("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));/**性别*/
				user.setBirthday(rs.getDate("birthday"));/**出生日期*/
				user.setEducation(rs.getString("education"));/**学历*/
				user.setTelephone(rs.getString("telephone"));/**电话*/
				user.setInterest(rs.getString("interest"));/**兴趣爱好*/
				user.setPath(rs.getString("path"));/**简历文件路径*/
				user.setFilename(rs.getString("filename"));/**简历文件名*/
				user.setRemark(rs.getString("remark"));/**备注*/
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			try {
				e.printStackTrace();
				throw new Exception("操作出现异常");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		return user;
	}

	@Override
	public void deleteUser(Serializable uid) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt =null;
        DBUtils dbc =null;
        StringBuilder sql = new StringBuilder();
        sql.append("delete from s_user where userID = ?");
        try{
        	dbc = new DBUtils();
        	pstmt = dbc.getConnection().prepareStatement(sql.toString());
        	pstmt.setInt(1, (Integer)uid);
        	pstmt.executeUpdate();
        	pstmt.close();
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        finally{
        	dbc.close();
        }
	}

	@Override
	public void updateUser(User user) {
		String sql = "UPDATE S_User SET username=?,password=?,sex=?,birthday=?,"
				+ "education=?,telephone=?,interest=?,path=?,filename=?,remark=? WHERE userID=?";
		PreparedStatement pstmt = null;
		DBUtils dbc = null;
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DBUtils();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());/**用户姓名*/
			pstmt.setString(2, user.getPassword());/**登录密码*/
			pstmt.setString(3, user.getSex());/**性别*/
			if(user.getBirthday()!=null){
				pstmt.setDate(4, new Date(user.getBirthday().getTime()));/**出生日期*/
			}else{
				pstmt.setDate(4, null);/**出生日期*/
			}
			pstmt.setString(5, user.getEducation());/**学历*/
			pstmt.setString(6, user.getTelephone());/**电话*/
			pstmt.setString(7, user.getInterest());/**兴趣爱好*/
			pstmt.setString(8, user.getPath());/**简历文件路径*/
			pstmt.setString(9, user.getFilename());/**简历文件名*/
			pstmt.setString(10, user.getRemark());/**备注*/
			pstmt.setInt(11, Integer.parseInt(user.getUserID().toString()));
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			try {
				e.printStackTrace();
				throw new Exception("操作出现异常");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
	}

	@Override
	public void saveUser(User user) {
		String sql = "INSERT INTO S_User (username,password,sex,birthday,"
				+ "education,telephone,interest,path,filename,remark) VALUES (?,?,"
				+ "?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		DBUtils dbc = null;
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DBUtils();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());/**用户姓名*/
			pstmt.setString(2, user.getPassword());/**登录密码*/
			pstmt.setString(3, user.getSex());/**性别*/
			pstmt.setDate(4, new Date(user.getBirthday().getTime()));/**出生日期*/
			pstmt.setString(5, user.getEducation());/**学历*/
			pstmt.setString(6, user.getTelephone());/**电话*/
			pstmt.setString(7, user.getInterest());/**兴趣爱好*/
			pstmt.setString(8, user.getPath());/**简历文件路径*/
			pstmt.setString(9, user.getFilename());/**简历文件名*/
			pstmt.setString(10, user.getRemark());/**备注*/
			pstmt.setInt(11, Integer.parseInt(user.getUserID().toString()));
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw new Exception("insert操作出现异常");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
	}
	
}
