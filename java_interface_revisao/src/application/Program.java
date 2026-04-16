package application;

import entities.CarRental;
import entities.Vehicle;
import exception.RentalException;
import services.BrazilTaxService;
import services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    private static final Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    public static void main (String[] args) {
        do {
            try {
                IO.println("Dados do aluguel:");

                IO.print("Modelo: ");
                String modelo = sc.nextLine();

                if (modelo.isEmpty()) {
                    IO.println("O modelo não pode estar em branco!");
                    return;
                }

                IO.print("Data de Inicial (DD/MM/YYYY): ");
                LocalDateTime startDate = LocalDateTime.parse(sc.nextLine(), dtf);

                IO.print("Data de Final (DD/MM/YYYY): ");
                LocalDateTime endDate = LocalDateTime.parse(sc.nextLine(), dtf);

                if (startDate.isBefore(LocalDateTime.now()) || endDate.isBefore(LocalDateTime.now())) {
                    IO.println("Somente datas futuras.");
                    return;
                }

                if (startDate.equals(endDate)) {
                    IO.println("Data de retirada não pode ser igual a data de saída!");
                    return;
                }

                IO.print("Valor por hora: ");
                double pricePerHour = sc.nextDouble();
                sc.nextLine();

                IO.print("Valor por dia: ");
                double pricePerDay = sc.nextDouble();
                sc.nextLine();

                if (pricePerHour <= 0 || pricePerDay <= 0) {
                    IO.println("O valor não pode ser menor ou igual a zero!");
                    return;
                }
                CarRental carRental = new CarRental(startDate, endDate, new Vehicle(modelo));

                RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
                rentalService.processInvoice(carRental);

                IO.println("Invoice Resumo:");
                IO.println("Pagamento basico: " + convString(carRental.getInvoice().getBasicPayment()));
                IO.println("Taxa: " + convString(carRental.getInvoice().getTax()));
                IO.println("Pagamento Total: " + convString(carRental.getInvoice().totalPayment()));

            } catch (RentalException err) {
                IO.println("Erro: " + err.getMessage());
            } catch (DateTimeParseException err) {
                IO.println("Erro: digite uma data válida!");
            } catch (InputMismatchException err) {
                IO.println("Erro: digite um valor válido!");
            }

        if(!confirmar("\nDeseja cadastrar um novo aluguel? (S/N) ")) {
            return;
        }

        } while (true);
    }

    public static boolean confirmar(String message) {
        IO.print(message);

        String option = sc.nextLine();

        if (option.isEmpty()) {
            IO.println("Encerrando operação!");
            return false;
        }
        char optionSelected = option.toUpperCase().charAt(0);

        return optionSelected == 'S';
    }

    private static String convString(double valor) {
        return String.format("%.2f", valor);
    }
}
