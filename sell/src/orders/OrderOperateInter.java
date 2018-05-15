package orders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
/**
 * 订单操作接口
 * @author mailian
 *
 */

public interface OrderOperateInter {
	// Order 操作
	//public String payTheCart(int arg_machine_id,int arg_user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException; //根据 machineID 和 userID 定位购物车，把购物车信息加到订单去，返回订单号

	public  String createOrderSN() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException; //生成订单号，形式：年月日时分秒+五位随机数，如：17111602372700000 ，不能重复

	public  String createOrderToken() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException; //付款之后再产生，同一台机器不能有相同的提取码，暂定5位

	public void changeOrderStatus(String arg_ordersn, int arg_status) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;//根据订单号改变订单状态

	public void payTheOrder(String arg_ordersn); //可先不实现，订单的付款

	public void searchOrderRetire() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException; //同上，搜索过期订单，设置过期，把库存加回去

	public Orders getOrderInfo(List<Map> arg_condition) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException; //根据条件返回订单信息

	String payTheCart(String arg_user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

}
