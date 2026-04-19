package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymenteService onlinePaymenteService;

    public ContractService(OnlinePaymenteService onlinePaymenteService) {
        this.onlinePaymenteService = onlinePaymenteService;
    }

    public void processContract(Contract contract, int months) {
        double parcBasic = contract.getTotalValue() / months;
        for (int i = 1; i <= months; i++) {
            double parcInterest = parcBasic + onlinePaymenteService.interest(parcBasic, i);
            double parcFee = parcInterest + onlinePaymenteService.paymentFee(parcInterest);

            LocalDate dueDate = addMonths(contract.getDate(), i);

            contract.getInstallments().add(new Installment(dueDate, parcFee));
        }
    }

    private LocalDate addMonths(LocalDate date, int months) {
        return date.plusMonths(months);
    }
}
