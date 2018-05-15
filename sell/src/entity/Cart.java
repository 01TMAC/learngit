package entity;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class Cart {
	private long ID;
	private long machineID;
	private long userID;
	private long updateTime;
	private long createTime;
	private JSONObject goodsList;//json����
	private double price;//�ܼ�
	private Map<Long,Item> items=new HashMap<Long,Item>();//��ƷID  ��Ŀ��¼
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public long getMachineID() {
		return machineID;
	}
	public void setMachineID(long machineID) {
		this.machineID = machineID;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public JSONObject getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(JSONObject goodsList) {
		this.goodsList = goodsList;
	}
	public double getPrice() {
		return price;
//	return (product.getPrice()*amount);
	}
	public void setPrice(double peice) {
		this.price = peice;
	}
	//�����Ʒ�����ﳵ
	public void addItem(Product product,int amount){
		if(items.containsKey(product.getID())){
			return;
		}
		Item item=new Item(amount,product);
		items.put(product.getID(),item);
	}
	//������ƷID�ı乺�ﳵ��ĸ���
	public void modifyNumByProductID(long productID,int amount){
		Item item=items.get(productID);
		item.setAmount(amount);
	}
	public void deleteItemByproductID(long productID){
		items.remove(productID);
	}
	//	��չ��ﳵ
	public void clear(){
		items.clear();
	}
	public Map<Long, Item> getItems() {
		return items;
	}
	//��ù��ﳵ��Ʒ��������
	public int getItemsSize(){
		return items.size();
	}
	//���ﳵ�Ƿ��
	public boolean isEmpty(){
		return items.isEmpty();
	}
	public double sumPrice(){
		double sum=0;
		for(Long id:items.keySet()){
			Item item=items.get(id);
			sum+=item.getCost();
		}
		return sum;
	}
	public void setItems(Map<Long, Item> items) {
		this.items = items;
	}
	//
	public Map<Long,Item> getItem(){
		return items;
	}
	
}
