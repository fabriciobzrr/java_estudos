package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
        // Valor do contrato dividido pelo número de parcelas
        Double basicInstallment = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            // Valor da parcela + juro mensal da parcela
            Double updatedInstallment = basicInstallment + onlinePaymentService.interest(basicInstallment, i);
            // Valor da parcela com juro mensal + taxa de pagamento
            Double fullInstallment = updatedInstallment + onlinePaymentService.paymentFee(updatedInstallment);
            LocalDate dueDate = updateDate(contract.getDate(), i);

            contract.getInstallments().add(new Installment(dueDate, fullInstallment));
        }
    }

    private LocalDate updateDate(LocalDate date, Integer quantityInstallment) {
        return date.plusMonths(quantityInstallment);
    }
}

