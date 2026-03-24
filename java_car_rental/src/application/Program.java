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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Scanner sc = new Scanner(System.in);

        IO.println("======================================");
        IO.println("Informe os dados de aluguel");
        IO.print("Modelo do carro: ");
        String model = sc.nextLine();

        IO.print("Data de Retirada (DD/MM/YYYY HH:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), dtf);

        IO.print("Data de Devolução (DD/MM/YYYY HH:mm): ");
        LocalDateTime end = LocalDateTime.parse(sc.nextLine(), dtf);

        IO.print("Preço por hora: ");
        Double priceHour = sc.nextDouble();

        IO.print("Preço por dia: ");
        Double priceDay = sc.nextDouble();
        IO.println("======================================");

        CarRental carRental = new CarRental(start, end, new Vehicle(model));
        RentalService rentalService = new RentalService(priceHour, priceDay, new BrazilTaxService());
        rentalService.processInvoice(carRental);

        IO.println();
        IO.println("Detalhes do Pagamento:");
        IO.println("======================================");
        IO.println("Subtotal a pagar: R$ " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        IO.println("Taxas e Impostos: R$ " + String.format("%.2f", carRental.getInvoice().getTax()));
        IO.println("======================================");
        IO.println("Total a pagar: R$ " + String.format("%.2f", carRental.getInvoice().totalPayment()));
        IO.println("======================================");

        sc.close();
    }
}
