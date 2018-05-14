package goods;

public class Goods {
	private int machineID;
	private int status;
	private String name;
	private int typeID;
	private int stock;
	private double price;
	
	public Goods(){
		
	}
	public Goods(int machineID, int status, String name, int typeID, int stock, double price) {
		super();
		this.machineID = machineID;
		this.status = status;
		this.name = name;
		this.typeID = typeID;
		this.stock = stock;
		this.price = price;
	}
	
	public int getMachineID() {
		return machineID;
	}
	public void setMachineID(int machineID) {
		this.machineID = machineID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
