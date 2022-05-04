package applications;

import java.util.Scanner;
import java.util.Locale;
import entities.Vehicle;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import entities.CarRental;
import Services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Scanner sc = new Scanner(System.in);
		
		
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
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay);
		rentalService.processInvoice(carRental);
		
		System.out.println(carRental.getInvoice().toString());
		sc.close();
	}

}
