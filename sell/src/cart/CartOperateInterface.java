package cart;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public interface CartOperateInterface {

	double getPrice(String goodsListStr)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	Map getItemList(String goodsListStr);

	void showItemList(Map itemList);

	//从购物车加货物
	void addToCart(String userID, String goodsID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	//从购物车减货物
	void subToCart(String userID, String goodsID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

}