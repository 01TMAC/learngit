package hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.mysql.jdbc.ResultSetMetaData;

/**
 * 数据库增删改查操作
 * @author mailian
 * @con 连接
 * @stmt 操作语句
 *
 */
public class JDBCUtils implements DB_Operate{
	private Connection con ;
	private PreparedStatement ps ;
	private ListResource listResource;
	Properties pps;
	
	
	public JDBCUtils() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		
			pps = new Properties();
			pps.load(JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties"));
			Class.forName(pps.getProperty("classname"));		
	}
	//sql语句执行返回影响的数据数目,list用于保存参数
	private int query(String sql,List list) throws SQLException
	{
		con = DriverManager.getConnection(pps.getProperty("url"),pps.getProperty("username"),
				  pps.getProperty("userpassword"));
		ps = con.prepareStatement(sql);
		int paramNum = list.size();
			for(int i = 0;i<paramNum;i++)
			{
				switch(GetType.getType(list.get(i)))
				{
					case "String":
						ps.setString(i+1,(String)list.get(i));
						break;
					case "Integer":
						ps.setInt(i+1,(int)list.get(i));
						break;
					case "Double":
						ps.setDouble(i+1,(double)list.get(i));
						break;	
					case "Long":
						ps.setLong(i+1,(long)list.get(i));
						break;	
				}
			}	
		
		int affectedNum = ps.executeUpdate();
		ps.close();
		con.close();
		return affectedNum;	
	}
	//数据库增加数据操作返回影响的数据数目
	public int insert(String sql,List list) throws SQLException
	{
		return this.query(sql,list);
	}
	//数据库删除数据操作返回影响的数据数目
	public int delete(String sql,List list) throws SQLException
	{
		return this.query(sql,list);
	}
	//数据库修改数据操作返回影响的数据数目
	public int update(String sql,List list) throws SQLException
	{
		return this.query(sql,list);
	}
	//数据库查询返回相对应的list列表
	public ListResource execToList(String sql,List list) throws SQLException
	{
		con = DriverManager.getConnection(pps.getProperty("url"),pps.getProperty("username"),
				  pps.getProperty("userpassword"));
		ps = con.prepareStatement(sql);
		int paramNum = list.size();
		if(paramNum > 0);
		{
			for(int i = 0;i<paramNum;i++)
			{
				switch(GetType.getType(list.get(i)))
				{
					case "String":
						ps.setString(i+1,(String)list.get(i));
						break;
					case "Integer":
						ps.setInt(i+1,(int)list.get(i));
						break;
					case "Double":
						ps.setDouble(i+1,(double)list.get(i));
						break;	
					case "Long":
						ps.setLong(i+1,(long)list.get(i));
						break;	
					default:
							System.out.println("找不到所需的类型");
				}
			}
		}
		
		
		ResultSet rs = ps.executeQuery();
		java.sql.ResultSetMetaData md = rs.getMetaData();
		int num = md.getColumnCount();
		List listOfRows = new ArrayList();
		listResource=new ListResource();
		if(rs!=null){
		while (rs.next()) {
			Map mapOfColValues = new HashMap(num);
		//封装单行数据
		for (int i = 1; i <= num; i++) {
			mapOfColValues.put(md.getColumnName(i), rs.getObject(i));
		}
		//单行数据放进list表
		listOfRows.add(mapOfColValues);
		}
		}
		//list表封装成ListResource用于后续操作
		//if(listOfRows.size()>0)
		listResource.setDataList(listOfRows);
		//返回ListResource列表
		rs.close();
		ps.close();
		con.close();
		return listResource;
	}
	@Override
	public ListResource execToList(String sql) throws SQLException, ClassNotFoundException {
		con = DriverManager.getConnection(pps.getProperty("url"),pps.getProperty("username"),
				  pps.getProperty("userpassword"));
		ps = con.prepareStatement(sql);
		

		ResultSet rs = ps.executeQuery();
		java.sql.ResultSetMetaData md = rs.getMetaData();
		int num = md.getColumnCount();
		List listOfRows = new ArrayList();
		listResource=new ListResource();
		while (rs.next()) {
			Map mapOfColValues = new HashMap(num);
		//封装单行数据
		for (int i = 1; i <= num; i++) {
			mapOfColValues.put(md.getColumnName(i), rs.getObject(i));
		}
		//单行数据放进list表
		listOfRows.add(mapOfColValues);
		
		}
		//list表封装成ListResource用于后续操作
		listResource.setDataList(listOfRows);
		rs.close();
		ps.close();
		con.close();
		//返回ListResource列表
		return listResource;
	}
}
