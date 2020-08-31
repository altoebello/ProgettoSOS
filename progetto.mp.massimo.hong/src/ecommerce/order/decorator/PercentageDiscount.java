package ecommerce.order.decorator;

import ecommerce.Order;

import ecommerce.order.OrderDecorator;

public class PercentageDiscount extends OrderDecorator{
		private int percentage;
		
		public PercentageDiscount(Order order,int percentage) {
			super(order);
			this.percentage = percentage;
			
		}
		
		public double getOrderCost() {
			System.out.println(super.getOrderCost());
			return super.getOrderCost()- (super.getOrderCost()/100*percentage);
		}
		
	

}
