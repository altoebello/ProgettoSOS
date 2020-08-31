package ecommerce.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ecommerce.Product;

public class Bundle extends Product{
	
	public Bundle(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	private List<Product> listOfProduct = new ArrayList<>();
	

	@Override
	public void addProduct(Product product) throws UnsupportedOperationException {
		listOfProduct.add(product);	
	}

	@Override
	public void removeProduct(Product product) throws UnsupportedOperationException {
		listOfProduct.remove(product);
	}
	
	public double getPrice() {
		double totalCost = 0;
		Iterator<Product> iterator = listOfProduct.iterator();
		while(iterator.hasNext()) {
			Product current = iterator.next();
			totalCost += current.getPrice();
		}
		return totalCost;
	}
	public void replenishStock(int quantity) {
		/*Iterator<Product> iterator = listOfProduct.iterator();
		while(iterator.hasNext()) {
			Product current = iterator.next();
			current.updateStock();
		}*/
		listOfProduct.stream().forEach(p -> p.replenishStock(quantity));
	}
	@Override
	public void updateStock() {
		/*Iterator<Product> iterator = listOfProduct.iterator();
		while(iterator.hasNext()) {
			Product current = iterator.next();
			current.updateStock();
		}*/
		listOfProduct.stream().forEach(p -> p.updateStock());
	}

	@Override
	public int getStock() {
		return 0;
		//
	}

}
