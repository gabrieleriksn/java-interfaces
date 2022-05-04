package services;

public interface TaxService {
	// Lembrando que uma interface estabele um contrato dos métodos que
	// devem estar presentes em uma classe que a implementar.
	double tax(double amount);
}
