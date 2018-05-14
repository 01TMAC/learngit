package goods;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import hibernate.DB_Operate;
import hibernate.JDBCUtils;
import hibernate.ListResource;
/**
 * 商品操作的实现类
 * @author mailian
 *
 */

public class GoodsOperateImpl implements GoodsOperateInter {
	private Goods goods;
	private DB_Operate dboperate ;
	
	

	public GoodsOperateImpl(DB_Operate dboperate,Goods goods) {
		this.goods = goods;
		this.dboperate = dboperate;
	}
	public GoodsOperateImpl() {
		
	}
	@Override
	public List<Goods> getGoodsInfo(Map arg_condition) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dboperate = new JDBCUtils();
		String sqlQuery = "select * from sell_goods where ";
		List list = new ArrayList();//查询参数列表
		List goodsList = new ArrayList();//商品列表
		ListResource dbList = new ListResource(); 
		
		Set set = arg_condition.keySet();//获取map中的键集合
		if(set == null)
			return null;//若查询不存在返回null
		else{
			
			for(Object obj : set){
				sqlQuery += obj + "= ?" ;
				list.add(arg_condition.get(obj));	
			}
			try {
				dbList = dboperate.execToList(sqlQuery, list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i = 0; i < dbList.getDataList().size(); i++)
			{
				Goods goods = new Goods();
				goods.setMachineID((int)dbList.getRow(i).getColValue("MachineID"));
				goods.setStatus((int)dbList.getRow(i).getColValue("Status"));
				goods.setName((String)dbList.getRow(i).getColValue("Name"));
				goods.setTypeID((int)dbList.getRow(i).getColValue("TypeID"));
				goods.setStock((int)dbList.getRow(i).getColValue("Stock"));
				goods.setPrice(Double.parseDouble(dbList.getRow(i).getColValue("Price").toString()));
				
				goodsList.add(goods);
				
			}
			return goodsList;
		}
	}

	@Override
	public int addGoods(int machineID, int status, String name, int typeID, int stock, double price) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String sqlInsert = "INSERT INTO sell_goods (MachineID,Status,Name,TypeID,Stock,Price) "
				+ "VALUES (?,?,?,?,?,?)";
		String sqlQuery = "select ID from sell_goods where MachineID = ? and Status = ? and Name = ?"
				+ "and TypeID = ? and Stock = ? and Price = ?";
		int id = 0;
		List list= new ArrayList(); 
		list.add(machineID);
		list.add(status);
		list.add(name);
		list.add(typeID);
		list.add(stock);
		list.add(price);
		try {
			dboperate.insert(sqlInsert, list);
			id = (int)dboperate.execToList(sqlQuery, list).getRow(0).getColValue("ID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("插入商品后id:"+id);
		return id;
	}

	
	@Override
	public void setGoodsStock(int stock, int id) throws ClassNotFoundException {
		List list = new ArrayList();
		list.add(stock);
		list.add(id);
		String sqlUpdate = "update sell_goods set Stock = ? where ID = ?";
		try {
			dboperate.update(sqlUpdate, list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public void setGoodsInfo(int machineID, int status, String name, int typeID, int stock, double price) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGoodsName(String name, int id) throws ClassNotFoundException {
		List list = new ArrayList();
		list.add(name);
		list.add(id);
		String sqlUpdate = "update sell_goods set Name = ? where ID = ?";
		try {
			dboperate.update(sqlUpdate, list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void setGoodsStatus(int status, int id) throws ClassNotFoundException {
		List list = new ArrayList();
		list.add(status);
		list.add(id);
		String sqlUpdate = "update sell_goods set Stock = ? where ID = ?";
		try {
			dboperate.update(sqlUpdate, list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
