package goods;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import hibernate.DB_Operate;
import hibernate.JDBCUtils;

public class GoodsTest {
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException
	{
		Map mapQuery = new HashMap();
	    mapQuery.put("TypeID", 2);
		Goods goods = new Goods();
		DB_Operate dboperate = new JDBCUtils();
		GoodsOperateImpl goodsOperateImpl = new GoodsOperateImpl( dboperate,goods);
		System.out.println(goodsOperateImpl.getGoodsInfo(mapQuery).size());
		
	}
}
