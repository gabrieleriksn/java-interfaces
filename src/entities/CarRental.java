package entities;

import java.util.Date;
import exceptions.DateException;

public class CarRental {
	
	private Date start;
	private Date finish;
	
	private Vehicle vehicle;
	private Invoice invoice;
	
	public CarRental() {
	}
	
	public CarRental(Date start, Date finish, Vehicle vehicle) throws DateException {
		if (finish.getTime() - start.getTime() < 0) {
			throw new DateException("Invalid dates. The return date must be after the pickup date!");
		}
		this.start = start;
		this.finish = finish;
		this.vehicle = vehicle;
	}
	
	
	public Date getStart() {
		return start;
	}
	
	public void setStart(Date start) {
		this.start = start;
	}
	
	public Date getFinish() {
		return finish;
	}
	
	public void setFinish(Date finish) {
		this.finish = finish;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public Invoice getInvoice() {
		return invoice;
	}
	
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}
