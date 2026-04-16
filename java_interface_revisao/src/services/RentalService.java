package services;

import entities.CarRental;
import entities.Invoice;
import exception.RentalException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class RentalService {

    private double pricePerHour;
    private double pricePerDay;

    private TaxService taxService;

    public RentalService(double pricePerHour, double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {
        if (carRental.getStartDate().isBefore(LocalDateTime.now()) || carRental.getEndDate().isBefore(LocalDateTime.now())) {
            throw new RentalException("Somente datas futuras!");
        }

        if (carRental.getEndDate().equals(carRental.getStartDate())) {
            throw new RentalException("Data de retirada não pode ser igual a data de saída!");
        }

        long millis = ChronoUnit.MINUTES.between(carRental.getStartDate(), carRental.getEndDate());
        double hours = (double) millis / 60;

        double basicPayment;
        if (hours <= 12.0) {
            basicPayment = Math.ceil(hours) * pricePerHour;
        } else {
            basicPayment = Math.ceil(hours / 24) * pricePerDay;
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));

    }
}
