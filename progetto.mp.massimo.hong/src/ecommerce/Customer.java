package ecommerce;



public abstract class Customer implements Observer{
	
	private String customerName;
	private Subscription subscription;
	private PaymentMethod paymentMethod;
	
	public Customer(String customerName) {
		this.customerName = customerName;
		this.subscription = createSubscription();
		
	}
	
	public abstract Subscription  createSubscription();
		
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public boolean pay(Order orderToPay)  {
		double amountToPay = subscription.apply(orderToPay);
		boolean result = paymentMethod.pay(amountToPay);
		orderToPay.updateProductStock();
		return result;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	@Override
	public void update(String message) {
		System.out.println(message);
	}
	
	public void observeProduct(Product product) {
		product.addObserver(this);
	}
}
