package ecommerce.paymentmethod;


import ecommerce.PaymentMethod;

public class CreditCard implements PaymentMethod{
	public boolean pay(double amount) {
		return true;
	}
}
