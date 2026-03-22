package application;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        IO.println("Informe os dados da locação");
        IO.print("Modelo do carro: ");
        String model = sc.nextLine();
        IO.print("Retirada do carro (DD/MM/YYYY HH:mm): ");
        LocalDateTime start  = LocalDateTime.parse(sc.nextLine(), dtf);
        IO.print("Devolução do carro (DD/MM/YYYY HH:mm): ");
        LocalDateTime end = LocalDateTime.parse(sc.nextLine(), dtf);

        CarRental carRental = new CarRental(start, end, new Vehicle(model));

        IO.println();
        IO.print("Preço por hora: ");
        Double pricePerHour = sc.nextDouble();
        IO.print("Preço por dia: ");
        Double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());

        rentalService.processInvoice(carRental);

        IO.println();
        IO.println("Total do serviço:");
        IO.println("=================================");
        IO.println("Pagamento básico: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        IO.println("Taxa: " + String.format("%.2f", carRental.getInvoice().getTax()));
        IO.println("=================================");
        IO.println("Total a pagar: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));
        IO.println("=================================");

        sc.close();
    }
}
