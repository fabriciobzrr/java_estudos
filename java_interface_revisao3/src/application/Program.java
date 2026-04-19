package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.time.LocalDate;
import java.util.List;

public class Program {
    public static void main (String[] args) {

        int number = 121;
        LocalDate date = LocalDate.now();
        double totalValue = 600;
        int months = 3;
        Contract contract = new Contract(number, date, totalValue);
        ContractService cs = new ContractService(new PaypalService());

        cs.processContract(contract, months);

        for(Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }

    }

}
