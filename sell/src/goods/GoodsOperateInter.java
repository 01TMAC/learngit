package goods;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
/**
 * 商品操作接口
 * @author mailian
 *
 */

public interface GoodsOperateInter {
	
	public List<Goods> getGoodsInfo(Map arg_condition) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException; //同上

	public int addGoods(int machineID, int status, String name, int typeID, int stock, double price) throws SQLException, ClassNotFoundException ;//除了 ID 字段外的所有字段，返回添加后的 ID

	public void setGoodsInfo(int machineID, int status, String name, int typeID, int stock, double price); //同上，待定

	public void setGoodsStock(int stock, int id) throws ClassNotFoundException;
	
	public void setGoodsName(String name, int id) throws ClassNotFoundException;
	
	public void setGoodsStatus(int status, int id) throws ClassNotFoundException;//同上，包括 name、status、

}
