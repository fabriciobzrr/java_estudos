package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
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

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Double getPricePerDouble() {
        return pricePerHour;
    }

    public void setPricePerDouble(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public BrazilTaxService getTaxService() {
        return taxService;
    }

    public void setTaxService(BrazilTaxService taxService) {
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental){
        ZoneId zone =  ZoneId.systemDefault();
        long t1 = carRental.getStartDate().atZone(zone).toInstant().toEpochMilli();
        long t2 = carRental.getEndDate().atZone(zone).toInstant().toEpochMilli();
        double hour = (double) (t2 - t1) / 1000 / 60 / 60;

//        LocalDateTime startTime = carRental.getStartDate();
//        LocalDateTime endTime = carRental.getEndDate();
//
//        // Maneira 1 - usando duration para saber a diferença entre datas e converter para Milisegundos
//        double hour = (double) Duration.between(startTime, endTime).toMillis() / 1000 / 60 / 60;
//
//        // Maneira 2 - usando ChronoUnit para saber a diferença de milisegundos entre datas
//        double hour = (double) ChronoUnit.MILLIS.between(
//                startTime.atZone(zone).toInstant(),
//                endTime.atZone(zone).toInstant()
//        ) / 1000 / 60 / 60;

        double basicPayment;
        if (hour <= 12) {
            basicPayment = pricePerHour * Math.ceil(hour);
        } else {
            double day = hour / 24;
            basicPayment = pricePerDay * Math.ceil(day);
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
