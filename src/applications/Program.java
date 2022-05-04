package applications;

import java.util.Scanner;
import java.util.Locale;
import java.util.Date;
import entities.Vehicle;
import entities.CarRental;
import exceptions.DateException;
import services.RentalService;
import services.BrazilTaxService;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter rental data");
			System.out.print("Car model: ");
			String model = sc.nextLine();
			
			Vehicle vehicle = new Vehicle(model);
			
			System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
			Date start = sdf.parse(sc.nextLine());
			System.out.print("Return (dd/MM/yyyy hh:mm): ");
			Date finish = sdf.parse(sc.nextLine());
			
			CarRental carRental = new CarRental(start, finish, vehicle);
			
			System.out.print("Enter price per hour: ");
			double pricePerHour = sc.nextDouble();
			System.out.print("Enter price per day: ");
			double pricePerDay = sc.nextDouble();
			
			RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
			rentalService.processInvoice(carRental);
			
			System.out.println(carRental.getInvoice());
		}
		
		catch (DateException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
