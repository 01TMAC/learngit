package objectForTable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import goods.Goods;

public class Item {
	private int amount;//加购物车的数量
	private Goods  product;
	private double cost;//总价
	
	public double getCost() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
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
	public Goods getProduct() {
		return product;
	}
	public void setProduct(Goods product) {
		this.product = product;
	}
	public Item(){
		super();
	}
	public Item(int amount,Goods product2){
		super();
		this.amount=amount;
		this.product=product2;
	}

	
}
