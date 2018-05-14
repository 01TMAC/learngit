package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	private final String DBDRIVER = "com.mysql.jdbc.Driver" ;
	private final String DBURL = "jdbc:mysql://localhost:3306/struts2_test?useUnicode=true&characterEncoding=utf8" ;
	private final String DBUSER = "root" ;
	private final String DBPASSWORD = "123456" ;
	private Connection conn = null ;

	public DBUtils()
	{
		try
		{
			Class.forName(DBDRIVER) ;
			this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;		
		}
		catch (Exception e)
		{
		}
	}
	// 取得数据库连接
	public Connection getConnection()
	{
		return this.conn ;
	}

	// 关闭数据库连接
	public void close()
	{
		try
		{
			this.conn.close() ;
		}
		catch (Exception e)
		{
		}		
	}
}
