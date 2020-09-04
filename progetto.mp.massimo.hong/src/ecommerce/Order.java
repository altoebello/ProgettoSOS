package ecommerce;

import ecommerce.exception.ProductNotAvailableException;

public interface Order {
	
	public double getOrderCost();
	public void addProduct(Product product,int quantity)throws ProductNotAvailableException;
	public void removeProduct(Product product);
	public void updateProductStock();
	public Spedition getSpedition();
	
}
