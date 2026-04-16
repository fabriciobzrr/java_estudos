package services;

public class BrazilTaxService implements TaxService {
    private static final double PERCENT_ONE = 0.15;
    private static final double PERCENT_TWO = 0.20;
    @Override
    public double tax(double amount) {

        if (amount > 100) {
            return amount * PERCENT_ONE;
        } else {
            return amount * PERCENT_TWO;
        }
    }

}
