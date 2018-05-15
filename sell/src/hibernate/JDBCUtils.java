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
 * ���ݿ���ɾ�Ĳ����
 * @author mailian
 * @con ����
 * @stmt �������
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
	//sql���ִ�з���Ӱ���������Ŀ,list���ڱ������
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
	//���ݿ��������ݲ�������Ӱ���������Ŀ
	public int insert(String sql,List list) throws SQLException
	{
		return this.query(sql,list);
	}
	//���ݿ�ɾ�����ݲ�������Ӱ���������Ŀ
	public int delete(String sql,List list) throws SQLException
	{
		return this.query(sql,list);
	}
	//���ݿ��޸����ݲ�������Ӱ���������Ŀ
	public int update(String sql,List list) throws SQLException
	{
		return this.query(sql,list);
	}
	//���ݿ��ѯ�������Ӧ��list�б�
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
							System.out.println("�Ҳ������������");
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
		//��װ��������
		for (int i = 1; i <= num; i++) {
			mapOfColValues.put(md.getColumnName(i), rs.getObject(i));
		}
		//�������ݷŽ�list��
		listOfRows.add(mapOfColValues);
		}
		}
		//list���װ��ListResource���ں�������
		//if(listOfRows.size()>0)
		listResource.setDataList(listOfRows);
		//����ListResource�б�
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
		//��װ��������
		for (int i = 1; i <= num; i++) {
			mapOfColValues.put(md.getColumnName(i), rs.getObject(i));
		}
		//�������ݷŽ�list��
		listOfRows.add(mapOfColValues);
		
		}
		//list���װ��ListResource���ں�������
		listResource.setDataList(listOfRows);
		rs.close();
		ps.close();
		con.close();
		//����ListResource�б�
		return listResource;
	}
}
