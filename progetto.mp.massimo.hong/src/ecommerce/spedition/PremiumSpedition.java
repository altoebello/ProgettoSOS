package ecommerce.spedition;

import ecommerce.Spedition;

public class PremiumSpedition implements Spedition{
	
	double speditionCost;
	
	public PremiumSpedition(double speditionCost) {
		this.speditionCost = speditionCost;
	}
	
	@Override
	public double getSpeditionCost() {
		
		return speditionCost;
	}
	
}
