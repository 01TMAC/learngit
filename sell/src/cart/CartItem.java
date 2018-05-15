package cart;

import goods.Goods;
/**
 * 购物车里的每种商品信息
 * @author mailian
 *
 */
public class CartItem {
	private String itemID;
	private int goodsNum;
	private Goods goods;

	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String goodsID) {
		this.itemID = goodsID;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	
}
