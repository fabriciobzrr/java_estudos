package application;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main (String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime data1 = LocalDateTime.parse("21/03/2026 10:30", dtf);
        LocalDateTime data2 = LocalDateTime.parse("21/03/2026 14:40", dtf);
        Vehicle vehicle = new Vehicle("Civic");

        CarRental carRental = new CarRental(data1, data2, vehicle);
        RentalService rentalService = new RentalService(10.0, 130.0, new BrazilTaxService());

        rentalService.processInvoice(carRental);

        IO.println("Pagamento básico: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        IO.println("Juros: " + String.format("%.2f", carRental.getInvoice().getTax()));
        IO.println("Total: " + String.format("%.2f", carRental.getInvoice().totalPayment()));
    }
}
