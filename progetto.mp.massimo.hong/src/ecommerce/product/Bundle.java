package ecommerce.product;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import ecommerce.Product;
import ecommerce.exception.ProductNotAvailableException;

public class Bundle extends Product{
	
	public Bundle(String name) {
		super(name);
	
	}

	private Map<Product,Integer> listOfProduct = new HashMap<>();
	

	@Override
	public void addProduct(Product product,int quantity) throws UnsupportedOperationException, ProductNotAvailableException {
		quantity += listOfProduct.getOrDefault(product, 0);
		
		int remainingStock = product.getStock();
		
		if(quantity > remainingStock)
			throw new ProductNotAvailableException("Product has : "+ remainingStock +" while you requested : "+quantity);
		listOfProduct.put(product,quantity);	
	}

	@Override
	public void removeProduct(Product product) throws UnsupportedOperationException {
		listOfProduct.remove(product);
	}
	
	public double getPrice() {
		double totalCost = 0;
		
		for ( Map.Entry<Product,Integer> entry : listOfProduct.entrySet()) {
			  totalCost += entry.getKey().getPrice() * entry.getValue();
		}
	
		return totalCost;
	}
	public boolean replenishStock(int quantity) {
	
		if(quantity <= 0)
			return false;
		listOfProduct.entrySet().stream().forEach(p -> p.getKey().replenishStock(quantity));
		return true;
	}
	
	@Override
	public void updateStock(int quantity) {
		for(int i = 0; i<quantity;i++) {
			listOfProduct.entrySet().stream().forEach(p -> p.getKey().updateStock(p.getValue()));
		}	
	}

	@Override
	public int getStock() {
		 return  listOfProduct.keySet().stream().mapToInt(p -> p.getStock()/listOfProduct.get(p))
				.min().orElse(0);
	}
	


}
