
public class Shopping {
	//商品名称
	private String name;
	//商品价格
	private int price;
	//商品数量
	private int count;
	@Override
	public String toString() {
		return "Shopping [name=" + name + ", price=" + price + ", count=" + count + "]";
	}
	public Shopping() {
		super();
	}
	public Shopping(String name, int price, int count) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
