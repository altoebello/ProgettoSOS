package ecommerce.product;

import ecommerce.Product;

public class SingleProduct extends Product{
	
	
	private double price;
	private int stock = 0;
	
	public SingleProduct(String productName, double price, int stock) {
		super(productName);
		this.price = price;
		this.stock = stock;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void replenishStock(int quantity) {
		if(stock == 0)
			notifyAllObservers(super.getProductName() + " has been replenished");
		this.stock += quantity;
		
	}
	
	public void updateStock() {
		this.stock --;
		if(stock == 0)
			notifyAllObservers(getProductName() + " has 0 stock!");
	}
	
	public int getStock() {
		return stock;
	}
	
	

	@Override
	public void addProduct(Product product) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Operation not allowed in leaf");
		
	}

	@Override
	public void removeProduct(Product product) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Operation not allowed in leaf");
	}		

}
