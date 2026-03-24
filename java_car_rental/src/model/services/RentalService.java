package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;

    private TaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {
        LocalDateTime start = carRental.getStart();
        LocalDateTime end = carRental.getEnd();

        ZoneId zone = ZoneId.systemDefault();

        double hours = (double) ChronoUnit.MILLIS.between(
                start.atZone(zone).toInstant(),
                end.atZone(zone).toInstant()
        ) / 1000 / 60 / 60;

        double days = hours / 24;

        double basicPayment;
        if (hours <= 12) {
            basicPayment = Math.ceil(hours) * pricePerHour;
        } else {
            basicPayment = Math.ceil(days) * pricePerDay;
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));

    }
}
