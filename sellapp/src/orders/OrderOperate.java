package orders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import entity.Product;
import goods.Goods;
import hibernate.DB_Operate;
import hibernate.JDBCUtils;
import hibernate.ListResource;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 
 * 订单操作
 * @author mailian
 *
 */

public class OrderOperate implements OrderOperateInter{
	private  static DB_Operate dboperate;
	
	
	public String payTheCart(String arg_user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dboperate = new JDBCUtils();
		
		String sqlQuery = "select * from sell_cart where UserID = ?";
		List listQuery = new ArrayList();
		/*listQuery.add(arg_machine_id);*/
		listQuery.add(arg_user_id);
		// TODO Auto-generated method stub
		ListResource resultList = new ListResource();
		resultList = dboperate.execToList(sqlQuery, listQuery);
//		int payMachineID = (int) resultList.getRow(0).getColValue("MachineID");
		String payUserID = (String) resultList.getRow(0).getColValue("UserID");
		String payGoodsList = (String) resultList.getRow(0).getColValue("GoodsList");
		String orderSN=createOrderSN();
		double payPrice = getPrice(payGoodsList);
		int orderStatus = 0;
		String payToken = createOrderToken();
		long payTime = Long.parseLong(orderSN.substring(0, 11));
		String sqlInsert = "insert into sell_order (OrderSN,UserID,GoodsList,Status,Price,Token,CreateTime) "
				+ "values (?,?,?,?,?,?,?)";
		List listInsert = new ArrayList();
		listInsert.add(orderSN);
//		listInsert.add(payMachineID);
		listInsert.add(payUserID);
		listInsert.add(payGoodsList);
		listInsert.add(orderStatus);
		listInsert.add(payPrice);
		listInsert.add(payToken);
		listInsert.add(payTime);
		
		dboperate.insert(sqlInsert, listInsert);
		
		
		
		return orderSN;
	}
	@Override
	public  String createOrderSN() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dboperate = new JDBCUtils();
		java.util.Random r=new java.util.Random(); 
		SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
	    String orderSN = format.format(new Date());
		for(int i=0;i<5;i++){ 
			orderSN += r.nextInt(10); 
		} 
		String sqlQuery = "SELECT OrderSN FROM sell_order WHERE OrderSN=?";
		List list = new ArrayList();
		list.add(orderSN);
		
		return orderSN;
		/*else createOrderSN();
		return null;*/
	}

	@Override
	public String createOrderToken() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dboperate = new JDBCUtils();
		String orderToken = "";
		java.util.Random r=new java.util.Random(); 
		for(int i = 0;i<5;i++)
			orderToken += r.nextInt(10);
		/*String sqlQuery = "SELECT OrderSN FROM sell_order WHERE OrderSN=?";
		List list = new ArrayList();
		list.add(orderToken);
		
		if(dboperate.execToList(sqlQuery, list).getDataList().size()==0)*/
		return orderToken;
	}

	@Override
	public void changeOrderStatus(String arg_ordersn, int arg_status) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		
		String sqlUpdate = "";
		List listUpdate = new ArrayList();
		
	
		
		sqlUpdate = "Update sell_order set Status = ? where OrderSN = ?";
		listUpdate.add(arg_status);
		listUpdate.add(arg_ordersn);
		dboperate.update(sqlUpdate, listUpdate);
		
	}

	@Override
	public void payTheOrder(String arg_ordersn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchOrderRetire() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		
		//查询过期订单
		String sqlQuery = "select GoodsList  from sell_order where Status = ?";
		//查询原有库存
		String sqlQueryStock = "select Stock from sell_goods where TypeID = ?";
		//更新库存
		String sqlUpdateStock = "update sell_goods set Stock = ? where TypeID = ?";
		int goodsStock = 0;
		List listQuery = new ArrayList();
		List listStock = new ArrayList();
		int orderStatus = 4;
		listQuery.add(orderStatus);
		
		
		ListResource dbList = new ListResource();
		dbList = dboperate.execToList(sqlQuery, listQuery);
		Product product;
		JSONObject jsonObject2;
		JSONArray jsonArray1;
		//循环取出过期订单的goodslist
		for(int i = 0;i < dbList.getDataList().size();i++)
		{
			String goodsList = (String) dbList.getRow(i).getColValue("GoodsList");
			product = null;
			jsonObject2 = null;
			jsonArray1 = JSONArray.fromObject(goodsList);
			//循环取出每个goodslist中的商品库存
			for (int j = 0; j < jsonArray1.size(); j++) {  
		         jsonObject2 = jsonArray1.getJSONObject(j);  
		         product = (Product) JSONObject.toBean(jsonObject2,  
		                    Product.class);
		         //查询原有的商品的库存
		         goodsStock = (int) dboperate.execToList(sqlQueryStock, listStock).getRow(j).getColValue("Stock");
		         //加上订单中过期的商品数量
		         goodsStock += product.getStock();
		         List listUpdate = new ArrayList();
		         listUpdate.add(goodsStock);
		         dboperate.update(sqlUpdateStock, listUpdate);
			}
			
		}
			
	}

	@Override
	public Orders getOrderInfo(List<Map> arg_condition) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		Orders order = new Orders();
		dboperate = new JDBCUtils();
		Map map = null;
		String sqlQuery = "select * from sell_order where ";
		List listQuery = new ArrayList();
		List result = new ArrayList();
		
		for(int i = 0;i<arg_condition.size();i++)
		{
			map = arg_condition.get(i);
			Iterator it = map.entrySet().iterator();
			while(it.hasNext())
			{
				 Map.Entry entry =  (Entry) it.next();
				 sqlQuery += entry.getKey()+"= ?";
				 listQuery.add(entry.getValue()); 
			}
		}
		 if(dboperate.execToList(sqlQuery, listQuery)!=null)
		 {
			 order.setCreateTime((Long) dboperate.execToList(sqlQuery, listQuery).getRow(0).getColValue("CreateTime"));
			 order.setGoodsList((String) dboperate.execToList(sqlQuery, listQuery).getRow(0).getColValue("GoodsList"));
			 //order.setMachineID((int) dboperate.execToList(sqlQuery, listQuery).getRow(0).getColValue("MachineID"));
			 order.setOrderSN((String) dboperate.execToList(sqlQuery, listQuery).getRow(0).getColValue("OrderSN"));
			 order.setPrice(Double.parseDouble(dboperate.execToList(sqlQuery, listQuery).getRow(0).getColValue("Price").toString()));
			 order.setStatus((int) dboperate.execToList(sqlQuery, listQuery).getRow(0).getColValue("Status"));
			 order.setToken((String) dboperate.execToList(sqlQuery, listQuery).getRow(0).getColValue("Token"));
			 order.setUserID((String) dboperate.execToList(sqlQuery, listQuery).getRow(0).getColValue("UserID"));
		 }
		 return order;
		 
	}
	//获取购物车的总价格
	
	
	
	public double getPrice(String goodsListStr) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException
	{
		
		double priceSum = 0;
		Goods product = null;
		JSONObject jsonObject2 = null;
		//字符串转json对象（这里是list）
		JSONArray jsonArray1 = JSONArray.fromObject(goodsListStr); 
		for (int i = 0; i < jsonArray1.size(); i++) { 
			//获取里面的单项
	         jsonObject2 = jsonArray1.getJSONObject(i); 
	         //将json单项转为指定类型的对象
	         product = (Goods) JSONObject.toBean(jsonObject2,  
	                    Goods.class);  
	         priceSum += product.getPrice();
	        }  
	        
		return priceSum;
	}
	/*public static void main(String [] args) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException
	{
		OrderOperate orderOperate = new OrderOperate();
		System.out.println(orderOperate.getPrice("[{\"machineID\":12,\"name\":\"kele\",\"price\":2.5,\"status\":1,\"stock\":11,\"typeID\":1}]"));
		List listQuery = new ArrayList();
		Map mapQuery = new HashMap();
		mapQuery.put("OrderSN", "17123116001913514");
		listQuery.add(mapQuery);
		orderOperate.getOrderInfo(listQuery);
		System.out.println(orderOperate.getOrderInfo(listQuery).getGoodsList());
	}*/
}
