package Services;

public class BrazilTaxService {
	
	public static Double tax(Double amount) {
		if (amount <= 100) {
			return 0.2 * amount;
		}
		
		return 0.15 * amount;
	}
}
