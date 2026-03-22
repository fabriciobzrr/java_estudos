package application;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main (String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Scanner sc = new Scanner(System.in);
        IO.println("Informe os dados do aluguel:");
        IO.print("Modelo do carro: ");
        String model =  sc.nextLine();

        IO.print("Data de Retirada (DD/MM/YYYY): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), dtf);

        IO.print("Data de Devolução (DD/MM/YYYY): ");
        LocalDateTime end = LocalDateTime.parse(sc.nextLine(), dtf);

        IO.print("Preço por hora: ");
        Double priceHour = sc.nextDouble();

        IO.print("Preço por dia: ");
        Double priceDay = sc.nextDouble();

        CarRental carRental = new CarRental(start, end, new Vehicle(model));
        RentalService rentalService = new RentalService(priceDay, priceHour, new BrazilTaxService());
        rentalService.processInvoice(carRental);

        IO.println();
        IO.println("DETALHES DO PAGAMENTO:");
        IO.println("======================================");
        IO.println("Subtotal: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        IO.println("Taxas e Impostos: " + String.format("%.2f", carRental.getInvoice().getTax()));
        IO.println("======================================");
        IO.println("Total: " + String.format("%.2f", carRental.getInvoice().totalPayment()));
        IO.println("======================================");


        sc.close();
    }
}
