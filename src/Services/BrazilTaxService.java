package services;

public class BrazilTaxService {
	
	public static double tax(double amount) {
		if (amount <= 100) {
			return 0.2 * amount;
		}
		
		return 0.15 * amount;
	}
}
