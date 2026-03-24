package model.services;

public class PaypalService implements OnlinePaymentService {

    private static final double PAYMENT_FEE = 2.0;
    private static final double INTEREST_MONTH = 1.0;

    public Double paymentFee(Double amount) {
        return amount * (PAYMENT_FEE / 100);
    }
    public Double interest(Double amount, Integer months){
        return amount * months * (INTEREST_MONTH / 100);
    }
}
