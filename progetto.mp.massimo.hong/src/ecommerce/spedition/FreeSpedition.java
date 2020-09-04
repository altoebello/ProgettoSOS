package ecommerce.spedition;

import ecommerce.Spedition;

public class FreeSpedition implements Spedition{

	@Override
	public double getSpeditionCost() {
		
		return 0;
	}

}
