package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
        double basicInstallment = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            double updatedInstallment = basicInstallment + onlinePaymentService.interest(basicInstallment, i);
            double fullInstallment = updatedInstallment + onlinePaymentService.paymentFee(updatedInstallment);
            LocalDate date = updatedDate(contract.getDate(), i);

            LocalDate dueDate = contract.getDate().plusMonths(i);

            contract.getInstallments().add(new Installment(date, fullInstallment));
        }
    }

    private LocalDate updatedDate(LocalDate date, int months) {
        LocalDate uptadedDate = date.plusMonths(months);
        return uptadedDate;
    }
}
