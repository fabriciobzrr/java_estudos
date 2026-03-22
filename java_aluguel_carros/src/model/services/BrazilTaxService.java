package model.services;

public class BrazilTaxService {
    public Double tax(Double value) {
        if (value < 100) {
            return value * 0.2;
        } else {
            return value * 0.15;
        }
    }
}
