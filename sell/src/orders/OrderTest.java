package orders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import hibernate.DB_Operate;
import hibernate.JDBCUtils;
import net.sf.json.JSONArray;

public class OrderTest {
	public static void main(String [] args) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException
	{
		/*
		 *  private long ID;
			private long machineID;
			private long typeID;//��Ʒ���ͣ���Ӧ���ͱ�
			private int status;
			private double price;
			private String name;
			private int stock;//���
		 */
		Product prouduct = new Product();
		prouduct.setID(12333);
		prouduct.setMachineID(123456);
		prouduct.setTypeID(123456);
		prouduct.setName("zdxh");
		prouduct.setPrice(2.3);
		prouduct.setStatus(0);
		prouduct.setStock(11);
		List goodsList = new ArrayList();
		goodsList.add(prouduct);
		goodsList.add(prouduct);
		//��list����תΪjson��������
		JSONArray goodsListJo = JSONArray.fromObject(goodsList);
		//��json����תΪ�ַ���
		String goodsListStr = goodsListJo.toString();
		String sqlInsert = "Insert into sell_cart (GoodsList,UserID,MachineID,CreateTime,UpdateTime)"
				+ "values (?,?,?,?,?)";
		List listQuery = new ArrayList();
		DB_Operate dboperate = new JDBCUtils();
		listQuery.add(goodsListStr);
		listQuery.add(12);
		listQuery.add(12);
		listQuery.add(1234);
		listQuery.add(1235);
		
		OrderOperate orderOperate= new OrderOperate();
		System.out.println(orderOperate.createOrderSN());
		
		
		
	}

}
