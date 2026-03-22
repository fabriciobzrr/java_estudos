package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RentalService {
    private Double pricePerDay;
    private Double pricePerHour;

    private BrazilTaxService taxService;

    public RentalService(Double pricePerDay, Double pricePerHour, BrazilTaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public void processInvoice (CarRental carRental) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime start = carRental.getStart();
        LocalDateTime end = carRental.getEnd();

        double hours = (double) ChronoUnit.MILLIS.between(
                start.atZone(zone).toInstant(),
                end.atZone(zone).toInstant()
        ) / 1000 / 60 / 60;

        double basicPayment;
        if (hours <= 12) {
            basicPayment = Math.ceil(hours) * pricePerHour;
        } else {
            basicPayment = Math.ceil(hours / 24) * pricePerDay;
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));

    }
}
