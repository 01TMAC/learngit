package orders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import hibernate.DB_Operate;
import hibernate.JDBCUtils;

public class Order {
	private long id;
//	private long userID;
//	private int status;
//	private long machineID;
//	private long createTime;
//	private double price;
//	private String orderSN;//订单号
//	private String token;//取货码；
	public Order(long id){
		this.id=id;
	} 
	public Order(){
		super();
	}
	public long getUserID() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (long) dboperate.execToList("select * from sell_order where ID = ?",list).getRow(0).getColValue("UserID");
	}
	public void setUserID(long userID) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(userID);
		list.add(id);
		String sql="update sell_order set UserID=? where ID =?";
		dboperate.update(sql, list);
	}
	public int getStatus() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (int) dboperate.execToList("select * from sell_order where ID = ?",list).getRow(0).getColValue("Status");
	}
	public void setStatus(int status) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(status);
		list.add(id);
		String sql="update sell_order set Status=? where ID =?";
		dboperate.update(sql, list);
	}
	public long getMachineID() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (long) dboperate.execToList("select * from sell_order where ID = ?",list).getRow(0).getColValue("MachineID");
	}
	public void setMachineID(long machineID) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(machineID);
		list.add(id);
		String sql="update sell_order set MachineID=? where ID =?";
		dboperate.update(sql, list);
	}
	public long getCreateTime() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (long) dboperate.execToList("select * from sell_order where ID = ?",list).getRow(0).getColValue("CreateTime");
	}
	public void setCreateTime(long createTime) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(createTime);
		list.add(id);
		String sql="update sell_order set CreateTime=? where ID =?";
		dboperate.update(sql, list);
	}
	public double getPrice() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (double) dboperate.execToList("select * from sell_order where ID = ?",list).getRow(0).getColValue("Price");
	}
	public void setPrice(double price) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(price);
		list.add(id);
		String sql="update sell_order set Price=? where ID =?";
		dboperate.update(sql, list);
	}
	public String getOrderSN() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (String) dboperate.execToList("select * from sell_order where ID = ?",list).getRow(0).getColValue("OrderSN");
	}
	public void setOrderSN(String orderSN) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(orderSN);
		list.add(id);
		String sql="update sell_order set OrderSN=? where ID =?";
		dboperate.update(sql, list);
	}
	public String getToken() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (String) dboperate.execToList("select * from sell_order where ID = ?",list).getRow(0).getColValue("Token");
	}
	public void setToken(String token) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(token);
		list.add(id);
		String sql="update sell_order set Token=? where ID =?";
		dboperate.update(sql, list);
	}
	public JSONObject getGoodsLIst() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(id);
	   return (JSONObject) dboperate.execToList("select * from sell_order where ID = ?",list).getRow(0).getColValue("GoodsList");
	}
	public void setGoodsLIst(JSONObject goodsList) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		list.add(goodsList);
		list.add(id);
		String sql="update sell_order set UserID=? where ID =?";
		dboperate.update(sql, list);
	}
//	private String goodsLIst;//json数据
}
