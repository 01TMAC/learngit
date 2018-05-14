package entity;

public class Product {
	private long ID;
	private long machineID;
	private long typeID;//商品类型，对应类型表
	private int status;
	private double price;
	private String name;
	private int stock;//库存
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
	public long getTypeID() {
		return typeID;
	}
	public void setTypeID(long typeID) {
		this.typeID = typeID;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
