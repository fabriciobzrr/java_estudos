package model.entities;

import java.security.InvalidParameterException;

public interface InterestService {

    double getInterestRate();

    default double payment(double amount, int months) {
        if (months < 1) {
            throw new InvalidParameterException("A quantidade de meses deve ser maior que zero.");
        }
        return amount * Math.pow((1 + getInterestRate() / 100), months);
    }
}
