package model.services;

public class BrazilTaxService implements TaxService{
    private static final double UP_HUNDRED = 0.2;
    private static final double MORETHEN_HUNDRED = 0.15;

    public Double tax(Double amount) {
        if (amount > 100) {
            return amount * MORETHEN_HUNDRED;
        } else {
            return amount * UP_HUNDRED;
        }
    }
}
