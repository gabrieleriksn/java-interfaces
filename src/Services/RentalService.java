package services;

import entities.CarRental;
import entities.Invoice;

public class RentalService {
	
	private Double pricePerHour;
	private Double pricePerDay;
	
	public RentalService() {
	}
	
	public RentalService(Double pricePerHour, Double pricePerDay) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
	}
	
	public Double getPricePerHour() {
		return pricePerHour;
	}
	
	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	
	public Double getPricePerDay() {
		return pricePerDay;
	}
	
	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	public void processInvoice(CarRental carRental) {
		
		long durationMillis = carRental.getFinish().getTime() - carRental.getStart().getTime();
		
		double durationHours = (double) durationMillis / 1000 / 60 / 60;
		double durationDays = (double) durationMillis / 1000 / 60 / 60 / 24; 
		
		int durationHoursRounded = (int) Math.ceil(durationHours);
		int durationDaysRounded = (int) Math.ceil(durationDays);
		
		double basicPayment;
		if (durationHoursRounded <= 12) {
			basicPayment = durationHoursRounded * pricePerHour;
		}
		
		else {
			basicPayment = durationDaysRounded * pricePerDay;
		}
		
		double tax = BrazilTaxService.tax(basicPayment);
		
		Invoice invoice = new Invoice(basicPayment, tax);
		carRental.setInvoice(invoice);
	}
}

