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
	private JSONObject goodsList;//json数据
	private double price;//总价
	private Map<Long,Item> items=new HashMap<Long,Item>();//商品ID  项目记录
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
	//添加商品到购物车
	public void addItem(Product product,int amount){
		if(items.containsKey(product.getID())){
			return;
		}
		Item item=new Item(amount,product);
		items.put(product.getID(),item);
	}
	//根据商品ID改变购物车里的个数
	public void modifyNumByProductID(long productID,int amount){
		Item item=items.get(productID);
		item.setAmount(amount);
	}
	public void deleteItemByproductID(long productID){
		items.remove(productID);
	}
	//	清空购物车
	public void clear(){
		items.clear();
	}
	public Map<Long, Item> getItems() {
		return items;
	}
	//获得购物车商品的总类数
	public int getItemsSize(){
		return items.size();
	}
	//购物车是否空
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
