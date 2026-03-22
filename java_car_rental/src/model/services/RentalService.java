package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;

    private BrazilTaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public BrazilTaxService getTaxService() {
        return taxService;
    }

    public void setTaxService(BrazilTaxService taxService) {
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
