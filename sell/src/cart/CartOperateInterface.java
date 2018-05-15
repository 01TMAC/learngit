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

	//�ӹ��ﳵ�ӻ���
	void addToCart(String userID, String goodsID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	//�ӹ��ﳵ������
	void subToCart(String userID, String goodsID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

}