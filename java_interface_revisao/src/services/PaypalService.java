package services;

public class PaypalService implements OnlinePaymenteService{

    private static final double PAYMENT_FEE = 0.02;
    private static final double INTEREST_RATE = 0.01;

    @Override
    public double interest(double amount, int months) {
        return amount * INTEREST_RATE * months;
    }

    @Override
    public double paymentFee(double amount) {
        return amount * PAYMENT_FEE;
    }
}
