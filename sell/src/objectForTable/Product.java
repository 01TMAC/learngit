package objectForTable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hibernate.DB_Operate;
import hibernate.JDBCUtils;

public class Product {
	private long id;
//	private long machineID;
//	private long typeID;//商品类型，对应类型表
//	private int status;
//	private double price;
//	private String name;
//	private int stock;//库存
	public Product(){
		super();
	}
	public Product(long id){
		this.id=id;
	}
	public long getMachineID() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (long) dboperate.execToList("select * from sell_goods where ID = ?",list).getRow(0).getColValue("MachineID");
	}
	public void setMachineID(long machineID) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(machineID);
		list.add(id);
		String sql="update sell_goods set MachineID=? where ID =?";
		dboperate.update(sql, list);
	}
	public long getTypeID() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (long) dboperate.execToList("select * from sell_goods where ID = ?",list).getRow(0).getColValue("TypeID");
	}
	public void setTypeID(long typeID) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(typeID);
		list.add(id);
		String sql="update sell_goods set typeID=? where ID =?";
		dboperate.update(sql, list);
	}
	public int getStatus() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (int) dboperate.execToList("select * from sell_goods where ID = ?",list).getRow(0).getColValue("Status");
	}
	public void setStatus(int status) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(status);
		list.add(id);
		String sql="update sell_goods set Status=? where ID =?";
		dboperate.update(sql, list);
	}
	public double getPrice() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (double) dboperate.execToList("select * from sell_goods where ID = ?",list).getRow(0).getColValue("Price");
	}
	public void setPrice(double price) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(price);
		list.add(id);
		String sql="update sell_goods set Price=? where ID =?";
		dboperate.update(sql, list);
	}
	public String getName() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (String) dboperate.execToList("select * from sell_goods where ID = ?",list).getRow(0).getColValue("Name");
	}
	public void setName(String name) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(name);
		list.add(id);
		String sql="update sell_goods set Name=? where ID =?";
		dboperate.update(sql, list);
	}
	public long getStock() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (long) dboperate.execToList("select * from sell_goods where ID = ?",list).getRow(0).getColValue("Stock");
	}
	public void setStock(int stock) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(stock);
		list.add(id);
		String sql="update sell_goods set Stock=? where ID =?";
		dboperate.update(sql, list);
	}
	
}
