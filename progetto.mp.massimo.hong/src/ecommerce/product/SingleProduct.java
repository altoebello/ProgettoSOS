package ecommerce.product;

import ecommerce.Product;

public class SingleProduct extends Product{
	
	
	private double price;
	private int stock = 0;
	
	public SingleProduct(String productName, double price, int stock) {
		super(productName);
		if(price <= 0 )
			throw new IllegalArgumentException("Price must be positive");
		if(stock <= 0)
			throw new IllegalArgumentException("Stock must be positive");
		this.price = price;
		this.stock = stock;
	}
	
	public double getPrice() {
		return price;
	}
	
	public boolean replenishStock(int quantity) {
		if(quantity <= 0)
			return false;
		if(stock == 0)
			notifyAllObservers(super.getProductName() + " has been replenished");
		this.stock += quantity;
		return true;
	}
	
	public void updateStock(int quantity) {
		stock = stock - quantity;
		if(stock == 0)
			notifyAllObservers(getProductName() + " has 0 stock!");
	}
	
	public int getStock() {
		return stock;
	}
	
	
	@Override
	public void addProduct(Product product,int quantity) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Operation not allowed in leaf");
		
	}

	@Override
	public void removeProduct(Product product) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Operation not allowed in leaf");
	}		

}
