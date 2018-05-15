package entity;

public class Order {
	private long ID;
	private long userID;
	private int status;
	private long machineID;
	private long createTime;
	private double price;
	private String orderSN;//订单号
	private String token;//取货码；
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getMachineID() {
		return machineID;
	}
	public void setMachineID(long machineID) {
		this.machineID = machineID;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOrderSN() {
		return orderSN;
	}
	public void setOrderSN(String orderSN) {
		this.orderSN = orderSN;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getGoodsLIst() {
		return goodsLIst;
	}
	public void setGoodsLIst(String goodsLIst) {
		this.goodsLIst = goodsLIst;
	}
	private String goodsLIst;//json数据
}
