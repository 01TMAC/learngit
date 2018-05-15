package orders;

public class Orders {
	private String OrderSN;
	private int machineID;
	private String userID;
	private String goodsList;
	private int status;
	private double price;
	private String token;
	private Long createTime;
	public String getOrderSN() {
		return OrderSN;
	}
	public void setOrderSN(String orderSN) {
		OrderSN = orderSN;
	}
	public int getMachineID() {
		return machineID;
	}
	public void setMachineID(int machineID) {
		this.machineID = machineID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String string) {
		this.userID = string;
	}
	public String getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(String goodsList) {
		this.goodsList = goodsList;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

}
