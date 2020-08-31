package ecommerce.paymentmethod;

import ecommerce.PaymentMethod;


public class PayPal implements PaymentMethod{
	public boolean pay(double amount) {
		return true;
	}
}
