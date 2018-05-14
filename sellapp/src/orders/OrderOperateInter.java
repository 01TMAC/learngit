package orders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
/**
 * ���������ӿ�
 * @author mailian
 *
 */

public interface OrderOperateInter {
	// Order ����
	//public String payTheCart(int arg_machine_id,int arg_user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException; //���� machineID �� userID ��λ���ﳵ���ѹ��ﳵ��Ϣ�ӵ�����ȥ�����ض�����

	public  String createOrderSN() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException; //���ɶ����ţ���ʽ��������ʱ����+��λ��������磺17111602372700000 �������ظ�

	public  String createOrderToken() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException; //����֮���ٲ�����ͬһ̨������������ͬ����ȡ�룬�ݶ�5λ

	public void changeOrderStatus(String arg_ordersn, int arg_status) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;//���ݶ����Ÿı䶩��״̬

	public void payTheOrder(String arg_ordersn); //���Ȳ�ʵ�֣������ĸ���

	public void searchOrderRetire() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException; //ͬ�ϣ��������ڶ��������ù��ڣ��ѿ��ӻ�ȥ

	public Orders getOrderInfo(List<Map> arg_condition) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException; //�����������ض�����Ϣ

	String payTheCart(String arg_user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

}
