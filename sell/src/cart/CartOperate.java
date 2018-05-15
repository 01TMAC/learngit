package cart;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import goods.Goods;
import goods.GoodsOperateImpl;
import hibernate.DB_Operate;
import hibernate.JDBCUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;


/**
 * 显示购物车列表
 * @author mailian
 *
 */
public class CartOperate implements CartOperateInterface {
	
	/* (non-Javadoc)
	 * @see cart.CartOperateInterface#getPrice(java.lang.String)
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see cart.CartOperateInterface#getItemList(java.lang.String)
	 */
	@Override
	public Map getItemList(String goodsListStr){
	    Map itemList ;
		JSONArray jGoodsList = JSONArray.fromObject(goodsListStr);
		List goodsList = new ArrayList();
		Goods goods = null;
		String goodsID = null;
		int goodsnum = 0;
		
		
		itemList = new HashMap();
	       for (int i = 0; i < jGoodsList.size(); i++) {  
	            JSONObject jsonObject2 = jGoodsList.getJSONObject(i);  
	               goods= (Goods) JSONObject.toBean(jsonObject2, Goods.class);  
	            goodsList.add(goods);  
	        }  
	        System.out.println(goodsList);
	        CartItem cartItem = null;
	        for(int i= 0 ;i<goodsList.size();i++)
	        {
	        	goods = (Goods)goodsList.get(i);
	        	goodsID =goods.getName();
	        	if(itemList.containsKey(goodsID)){
	        		cartItem =(CartItem) itemList.get(goodsID);
	        		cartItem.setGoodsNum(cartItem.getGoodsNum()+1);
	        	}
	        	else {	
	        			cartItem = new CartItem();
	        			cartItem.setGoods(goods);
	        			cartItem.setGoodsNum(1);
	        			cartItem.setItemID(goodsID);
	        			itemList.put(goodsID, cartItem);
	        		 }
	        	
	        }
		
		return itemList;
		
	}
	/* (non-Javadoc)
	 * @see cart.CartOperateInterface#showItemList(java.util.Map)
	 */
	@Override
	public void showItemList(Map itemList)
	{
		Iterator it = itemList.entrySet().iterator();
		while (it.hasNext()) {
		Map.Entry entry = (Entry) it.next();
		String key = (String) entry.getKey();
		CartItem value = (CartItem) entry.getValue();
		System.out.println("goodsID = " + key + "; num = " + value.getGoodsNum());
	}
	}
	//从购物车加货物
	/* (non-Javadoc)
	 * @see cart.CartOperateInterface#addToCart(int, java.lang.String)
	 */
	@Override
	public void addToCart(String userID,String goodsID) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		List goodsList = new ArrayList<>();
		String goodsListStr = "";
		JDBCUtils dbOperate = new JDBCUtils();
		String sqlQuery1 = "select GoodsList from sell_cart where UserID = ?";
		List listQuery1 = new ArrayList();
		listQuery1.add(userID);
		
		Map mapQuery = new HashMap();
		mapQuery.put("Name",goodsID);
		GoodsOperateImpl goodsOperate = new GoodsOperateImpl();
		Goods goods = goodsOperate.getGoodsInfo(mapQuery).get(0);
		goodsListStr = (String) dbOperate.execToList(sqlQuery1,listQuery1).getRow(0).getColValue("GoodsList");;
		if(goods.getStock()>0){
			if(goodsListStr==null)
			{
					goodsList = new ArrayList();
					goodsList.add(goods);
					goodsListStr = JSONArray.fromObject(goodsList).toString();
			}
			else{
					//goodsListStr = (String) dbOperate.execToList(sqlQuery1,listQuery1).getRow(0).getColValue("GoodsList");
					JSONArray jsonArray = JSONArray.fromObject(goodsListStr);   
			        goodsList = JSONArray.toList(jsonArray, new Goods(), new JsonConfig()); 
			        goodsList.add(goods);
			        jsonArray = JSONArray.fromObject(goodsList);
			        goodsListStr = jsonArray.toString();
			        //
			        
			    }
			String sqlUpdate = "update sell_cart set GoodsList = ? where UserID = ? ";
	        List listQuery = new ArrayList();
	        listQuery.add(goodsListStr);
	        listQuery.add(userID);
	        //显示购物车项目
	        this.showItemList(this.getItemList(goodsListStr));
	        
	        dbOperate.update(sqlUpdate, listQuery);
	        String sqlUpdate2 = "update sell_goods set Stock = Stock-1 where Name = ?";
	        List listUpdate2 = new ArrayList();
	        listUpdate2.add(goodsID);
	        dbOperate.update(sqlUpdate2, listUpdate2);
		 }   
	   }  
	//从购物车减货物
	/* (non-Javadoc)
	 * @see cart.CartOperateInterface#subToCart(int, java.lang.String)
	 */
	@Override
	public void subToCart(String userID,String goodsID) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		String sqlQuery1 = "select * from sell_cart where UserID = ?";
		List listQuery1 = new ArrayList();
		listQuery1.add(userID);
		JDBCUtils dbOperate = new JDBCUtils();
		String goodsListStr = (String) dbOperate.execToList(sqlQuery1,listQuery1).getRow(0).getColValue("GoodsList");
		JSONArray jsonArray = JSONArray.fromObject(goodsListStr);   
        List goodsList = JSONArray.toList(jsonArray, new Goods(), new JsonConfig());
        Goods goods = new Goods();
        
		for(int i=0;i<goodsList.size();i++)
		{
			goods = (Goods) goodsList.get(i);
			if(goods.getName().equals(goodsID)){
				if(goods.getStock()>0){
					goodsList.remove(i);
				}
				break;
			}
			
		}
		 jsonArray = JSONArray.fromObject(goodsList);
	     goodsListStr = jsonArray.toString();
	     String sqlUpdate = "update sell_cart set GoodsList = ? where UserID = ? ";
	     List listQuery = new ArrayList();
	     listQuery.add(goodsListStr);
	     listQuery.add(userID);
         dbOperate.update(sqlUpdate, listQuery);
         
         String sqlUpdate2 = "update sell_goods set Stock = Stock+1 where Name = ?";
	     List listUpdate2 = new ArrayList();
	     listUpdate2.add(goodsID);
	     dbOperate.update(sqlUpdate2, listUpdate2);
	}
		
	
	public static void main(String [] args) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		CartOperateInterface cartOperate = new CartOperate();
		/*String goodsStr = "[{\"machineID\":12,\"name\":\"kele\",\"price\":2.5,\"status\":1,\"stock\":11,\"typeID\":1},{\"machineID\":12,\"name\":\"kele\",\"price\":2.5,\"status\":1,\"stock\":11,\"typeID\":1},{\"machineID\":12,\"name\":\"xuebi\",\"price\":2.5,\"status\":1,\"stock\":11,\"typeID\":2}]";
		Map itemList = cartOperate.getItemList(goodsStr);
		cartOperate.showItemList(itemList);*/
		
		
		}
}
		
	


