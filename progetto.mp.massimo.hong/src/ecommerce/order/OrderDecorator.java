package ecommerce.order;

import ecommerce.Order;
import ecommerce.Product;
import ecommerce.Spedition;
import ecommerce.exception.ProductNotAvailableException;

public abstract class OrderDecorator implements Order{
	private Order order;
	
	public OrderDecorator(Order order) {
		if (order == null)
			 throw new NullPointerException("Order cannot be null");
		this.order = order;
	}
	
	public double getOrderCost() {
		return order.getOrderCost();
	}
	
	
	@Override
	public void updateProductStock(){
		order.updateProductStock();		
	}
	@Override
	public void addProduct(Product product,int quantity)throws ProductNotAvailableException {
		order.addProduct(product,quantity);
		
	}

	@Override
	public void removeProduct(Product product)  {
		order.removeProduct(product);
	}
	
	public Spedition getSpedition() {
		return order.getSpedition();
	}
	
}
