package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

import java.time.ZoneId;

public class RentalService {
    private Double pricerPerHour;
    private Double pricePerDay;

    private TaxService taxService;

    public RentalService(Double pricerPerHour, Double pricePerDay, TaxService taxService) {
        this.pricerPerHour = pricerPerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public Double getPricerPerHour() {
        return pricerPerHour;
    }

    public void setPricerPerHour(Double pricerPerHour) {
        this.pricerPerHour = pricerPerHour;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public TaxService getTaxService() {
        return taxService;
    }

    public void setTaxService(TaxService taxService) {
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {
        double hours = getHours(carRental);
        double basicPayment;
        if (hours <= 12) {
            basicPayment = Math.ceil(hours) * pricerPerHour;
        } else {
            double days = Math.ceil(hours) / 24;
            basicPayment = days * pricePerDay;
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }

    private Double getHours(CarRental carRental) {
        ZoneId zone = ZoneId.systemDefault();
        long start = carRental.getStart().atZone(zone).toInstant().toEpochMilli();
        long finish = carRental.getFinish().atZone(zone).toInstant().toEpochMilli();
        double hours = (double) (finish - start) / 1000 / 60 / 60;
        return hours;
    }
}
