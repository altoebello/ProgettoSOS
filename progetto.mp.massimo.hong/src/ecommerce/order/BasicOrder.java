package ecommerce.order;


import java.util.HashMap;
import java.util.Map;
import ecommerce.Customer;
import ecommerce.Order;
import ecommerce.Product;
import ecommerce.Spedition;
import ecommerce.exception.ProductNotAvailableException;

public class BasicOrder implements Order{
	
	private Spedition spedition;
	private Customer customer;
	private Map<Product,Integer> products = new HashMap<>();
	public BasicOrder(Spedition speditionType,Customer customer) {
		this.spedition = speditionType;
		this.customer = customer;
	}
	
	
	public double getOrderCost() {
		double totalCost = 0;
		for ( Map.Entry<Product,Integer> entry : products.entrySet()) {
			  totalCost += entry.getKey().getPrice() * entry.getValue();
		}
		return totalCost + spedition.getSpeditionCost();
	}
	
	
	public void addProduct(Product product,int quantity) throws ProductNotAvailableException {
		
		quantity += products.getOrDefault(product, 0);
		int remainingStock = product.getStock();
		if(quantity > remainingStock)
			throw new ProductNotAvailableException("Product has : "+ remainingStock +" while you requested : "+quantity);
		products.put(product, quantity);
		product.addObserver(customer);
			
	}
	
	public void updateProductStock() {
		for ( Map.Entry<Product,Integer> entry : products.entrySet()) {
			entry.getKey().updateStock(entry.getValue()); 
		}
	}
	
	public void removeProduct(Product product) {
		products.remove(product);
	}


	@Override
	public Spedition getSpedition() {
		return spedition;
	}
	
}
