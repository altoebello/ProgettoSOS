package ecommerce;

import ecommerce.customer.NormalCustomer;
import ecommerce.order.BasicOrder;
import ecommerce.order.decorator.AbsoluteDiscount;
import ecommerce.order.decorator.PercentageDiscount;
import ecommerce.paymentmethod.PayPal;
import ecommerce.product.Bundle;
import ecommerce.product.SingleProduct;
import ecommerce.spedition.FreeSpedition;

public class MainTest {
	
	public static void main(String[]args) throws Exception {
		
		Product p2 = new SingleProduct("OMAEWAMOUSHINDERU",50,10);
		Product p = new SingleProduct("Latuabellissimachiomafolta",100,50);
		Product bundle = new Bundle("IncredibleOffer");
		Product p3 = new SingleProduct("SAD",50,10);
		Product p4 = new SingleProduct("SOS",100,50);
		bundle.addProduct(p3);
		bundle.addProduct(p4);
		
		Customer client = new NormalCustomer("Fabio");
		

		
		Order testOrder = new BasicOrder(new FreeSpedition(), client);
		
		testOrder.addProduct(p2,1);
		testOrder.addProduct(p,50);
		testOrder.addProduct(bundle,1);
		
		Order absDiscOrd = new AbsoluteDiscount(testOrder,10);
		Order percDisc = new PercentageDiscount(absDiscOrd,10);
		client.setPaymentMethod(new PayPal());
		client.pay(percDisc);
		p.replenishStock(10);
	}
	
}
