package ecommerce.order;

import java.util.ArrayList;
import java.util.List;

import ecommerce.Customer;
import ecommerce.Order;
import ecommerce.Product;
import ecommerce.Spedition;

public class BasicOrder implements Order{
	
	private List<Product> productList = new ArrayList<>();
	private Spedition spedition;
	private Customer customer;
	
	public BasicOrder(Spedition speditionType,Customer customer) {
		this.spedition = speditionType;
		this.customer = customer;
	}
	
	
	public double getOrderCost() {
		double totalCost = 0;
		for(Product p : productList)
			totalCost += p.getPrice();
		return totalCost + spedition.getSpeditionCost();
	}
	
	
	public void addProduct(Product product,int quantity) {
		for(int i = 0; i<quantity;i++) {
			productList.add(product);
		}
		product.addObserver(customer);
			
	}
	
	public void updateProductStock() {
		/*Iterator<Product> iterator = productList.iterator();
		while(iterator.hasNext()) {
			Product current = iterator.next();
			current.updateStock();
		}*/
		productList.stream().forEach(p -> p.updateStock());
	}
	
	public void removeProduct(Product product) {
		productList.removeIf(p -> p.equals(product));
	}


	@Override
	public Spedition getSpedition() {
		return spedition;
	}
	
}
