package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.OnlinePaymentService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main (String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        IO.println("Informe os dados do contrato");

        IO.print("Número do contrato: ");
        Integer numberOfContract = sc.nextInt();

        IO.print("Data do contrato (DD/MM/AAAA): ");
        LocalDate date = LocalDate.parse(sc.next(), dtf);

        IO.print("Valor do contrato: ");
        Double totalValue = sc.nextDouble();

        Contract contract = new Contract(numberOfContract, date, totalValue);

        IO.print("Informe o número de parcelas do contrato: ");
        Integer numberOfInstallments = sc.nextInt();

        ContractService cs = new ContractService(new PaypalService());
        cs.processContract(contract, numberOfInstallments);

        IO.println();
        IO.println("=========================");
        IO.println("PARCELAMENTO:");
        IO.println("=========================");
        double total = 0;
        for(Installment installment : contract.getInstallments()){
            IO.println(installment);
            total += installment.getAmount();
        }
        IO.println("=========================");
        IO.println("TOTAL:       R$ " + String.format("%.2f", total));
        IO.println("=========================");


        sc.close();
    }
}
