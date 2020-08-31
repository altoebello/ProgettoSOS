package ecommerce;

public interface Order {
	
	public double getOrderCost();
	public void addProduct(Product product,int quantity);
	public void removeProduct(Product product);
	public void updateProductStock();
	public Spedition getSpedition();
}
