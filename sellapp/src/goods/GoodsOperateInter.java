package goods;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
/**
 * ��Ʒ�����ӿ�
 * @author mailian
 *
 */

public interface GoodsOperateInter {
	
	public List<Goods> getGoodsInfo(Map arg_condition) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException; //ͬ��

	public int addGoods(int machineID, int status, String name, int typeID, int stock, double price) throws SQLException, ClassNotFoundException ;//���� ID �ֶ���������ֶΣ�������Ӻ�� ID

	public void setGoodsInfo(int machineID, int status, String name, int typeID, int stock, double price); //ͬ�ϣ�����

	public void setGoodsStock(int stock, int id) throws ClassNotFoundException;
	
	public void setGoodsName(String name, int id) throws ClassNotFoundException;
	
	public void setGoodsStatus(int status, int id) throws ClassNotFoundException;//ͬ�ϣ����� name��status��

}
