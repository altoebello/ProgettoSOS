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
		/*Iterator<Product> iterator = listOfProduct.iterator();
		while(iterator.hasNext()) {
			Product current = iterator.next();
			totalCost += current.getPrice();
		}*/
		return totalCost;
	}
	public boolean replenishStock(int quantity) {
		/*Iterator<Product> iterator = listOfProduct.iterator();
		while(iterator.hasNext()) {
			Product current = iterator.next();
			current.updateStock();
		}*/
		if(quantity <= 0)
			return false;
		listOfProduct.entrySet().stream().forEach(p -> p.getKey().replenishStock(quantity));
		return true;
	}
	
	@Override
	public void updateStock(int quantity) {
		/*Iterator<Product> iterator = listOfProduct.iterator();
		while(iterator.hasNext()) {
			Product current = iterator.next();
			current.updateStock();
		}*/
		for(int i = 0; i<quantity;i++) {
			listOfProduct.entrySet().stream().forEach(p -> p.getKey().updateStock(p.getValue()));
		}
		
	}

	@Override
	public int getStock() {
		//return listOfProduct.values().stream().min((a,b)->a-b).orElse(0);
		Product p =  listOfProduct.keySet().stream().min((a,b) -> a.getStock()/listOfProduct.get(a)-b.getStock()/listOfProduct.get(b)).orElse(null);
		return p.getStock()/listOfProduct.get(p);
	}
	


}
