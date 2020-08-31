package ecommerce.customer;

import ecommerce.Customer;
import ecommerce.Subscription;


public class NormalCustomer extends Customer {

	public NormalCustomer(String customerName) {
		super(customerName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Subscription createSubscription() {
		// TODO Auto-generated method stub
		return order -> order.getOrderCost();
	}

}
