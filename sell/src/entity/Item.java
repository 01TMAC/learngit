package entity;

public class Item {
//	private long ID;
//	private long machineID;
//	private long userID;
//	private long updateTime;
	private int amount;//�ӹ��ﳵ������
	private Product product;
//	private long createTime;
//	private String goodsList;//json����
	private double cost;//����
	public double getCost() {
		return (product.getPrice()*amount);
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Item(){
		super();
	}
	public Item(int amount,Product product){
		super();
		this.amount=amount;
		this.product=product;
	}
//	public long getID() {
//		return ID;
//	}
//	public void setID(long iD) {
//		ID = iD;
//	}
//	public long getMachineID() {
//		return machineID;
//	}
//	public void setMachineID(long machineID) {
//		this.machineID = machineID;
//	}
//	public long getUserID() {
//		return userID;
//	}
//	public void setUserID(long userID) {
//		this.userID = userID;
//	}
//	public long getUpdateTime() {
//		return updateTime;
//	}
//	public void setUpdateTime(long updateTime) {
//		this.updateTime = updateTime;
//	}
//	public long getCreateTime() {
//		return createTime;
//	}
//	public void setCreateTime(long createTime) {
//		this.createTime = createTime;
//	}
//	public String getGoodsList() {
//		return goodsList;
//	}
//	public void setGoodsList(String goodsList) {
//		this.goodsList = goodsList;
//	}
	
}
