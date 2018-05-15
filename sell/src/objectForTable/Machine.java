package objectForTable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import hibernate.DB_Operate;
import hibernate.JDBCUtils;

public class Machine {
	private long id;
	public Machine(long id){
		this.id=id;
	}
	public String getName() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (String) dboperate.execToList("select * from sell_machine where ID = ?",list).getRow(0).getColValue("Name");
	}
	public long getX() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (long)dboperate.execToList("select * from sell_machine where ID = ?",list).getRow(0).getColValue("X");
	}
	public long getY() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (long) dboperate.execToList("select * from sell_machine where ID = ?",list).getRow(0).getColValue("Y");
	}
	public int getStatus() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (int) dboperate.execToList("select * from sell_machine where ID = ?",list).getRow(0).getColValue("Status");
	}
	public JSONObject getTypeList() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (JSONObject) dboperate.execToList("select * from sell_machine where ID = ?",list).getRow(0).getColValue("TypeList");
	}
	public int getPermit() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (int) dboperate.execToList("select * from sell_machine where ID = ?",list).getRow(0).getColValue("Permit");
	}
	public void setName(String name) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(name);
		list.add(id);
		String sql="update sell_machine set Name=? where ID =?";
		dboperate.update(sql, list);
	}
	public void setX(long x) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException{
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(x);
		list.add(id);
		String sql="update sell_machine set X=? where ID =?";
		dboperate.update(sql, list);
	}
	public void setY(long y) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(y);
		list.add(id);
		String sql="update sell_machine set Y=? where ID =?";
		dboperate.update(sql, list);
	}
	public void setStatus(int status) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(status);
		list.add(id);
		String sql="update sell_machine set Status=? where ID =?";
		dboperate.update(sql, list);
	}
	public void setTypeList(JSONObject typeList) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(typeList);
		list.add(id);
		String sql="update sell_machine set TypeList=? where ID =?";
		dboperate.update(sql, list);
	}
	public void setPermit(int permit) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(permit);
		list.add(id);
		String sql="update sell_machine set Permit=? where ID =?";
		dboperate.update(sql, list);
	}
}
