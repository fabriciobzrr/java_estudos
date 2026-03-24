package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main (String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        IO.println("Informe os dados do contrato");
        IO.println("================================================");

        IO.print("Número do contrato: ");
        Integer numberOfContract = sc.nextInt();

        IO.print("Data (DD/MM/AAAA): ");
        LocalDate date = LocalDate.parse(sc.next(), dtf);

        IO.print("Valor do contrato: ");
        Double totalValue = sc.nextDouble();

        Contract contract = new Contract(numberOfContract, date, totalValue);

        IO.print("Insira o número de parcelas do contrato: ");
        Integer months = sc.nextInt();
        IO.println("================================================");

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, months);

        IO.println();
        IO.println("=======================");
        IO.println("NÚMERO DE PARCELAS:");
        IO.println();
        double sum = 0.0;
        for (Installment installment : contract.getInstallments()) {
            sum += installment.getAmount();
            IO.println(installment);
        }
        IO.println();
        IO.println("=======================");
        IO.println("TOTAL: R$ " + String.format("%.2f", sum));
        IO.println("=======================");

        sc.close();
    }
}
