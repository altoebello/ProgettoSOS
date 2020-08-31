package ecommerce.order.decorator;

import ecommerce.Order;
import ecommerce.order.OrderDecorator;

public class AbsoluteDiscount extends OrderDecorator{
	private double discountAmount;
	public AbsoluteDiscount(Order order,double discountAmount) {
		super(order);
		this.discountAmount = discountAmount;
	}
	
	public double getOrderCost() {
		return super.getOrderCost()-discountAmount;
	}
	

	
	
}
