package entities;

public class Invoice {
	
	private Double basicPayment;
	private Double tax;
	
	public Invoice() {
	}
	
	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}
	
	public Double getBasicPayment() {
		return basicPayment;
	}
	
	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}
	
	public Double getTax() {
		return tax;
	}
	
	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	public Double totalPayment() {
		return basicPayment + tax;
	}
	
	@Override
	public String toString() {
		return "INVOICE:" 
	           + String.format("%n") 
	           + "Basic payment: " 
	           + String.format("%.2f", basicPayment) 
	           + String.format("%n")
	           + "Tax: "
	           + String.format("%.2f", tax)
	           + String.format("%n")
	           + "Total Payment: "
	           + String.format("%.2f", totalPayment());
	}
}
