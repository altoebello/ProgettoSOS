package ecommerce;

public abstract class Product extends Subject{
	
	private String name;
	
	public Product(String name) {
		this.name = name;
	}
	
	public String getProductName() {
		return name;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Product )
			return ((Product) obj).getProductName().equals(this.getProductName());
		return false;
	}
	public abstract double getPrice();
	public abstract void updateStock();
	public abstract int getStock();
	public abstract void addProduct(Product product)throws UnsupportedOperationException;
	public abstract void replenishStock(int quantity);
	public abstract void removeProduct(Product product)throws UnsupportedOperationException;

}
