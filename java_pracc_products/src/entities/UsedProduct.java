package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {

  public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private LocalDate manufactureDate;

  public UsedProduct() {
    super();
  }

  public UsedProduct(String name, Double price, LocalDate manufactureDate) {
    super(name, price);
    this.manufactureDate = manufactureDate;
  }

  public LocalDate getManufactureDate() {
    return manufactureDate;
  }

  public void setManufactureDate(LocalDate manufactureDate) {
    this.manufactureDate = manufactureDate;
  }


  @Override
  public String priceTag() {
    return super.getName() 
    + " (usado) R$ " 
    + String.format("%.2f", super.getPrice()) 
    + " (Data de fabricação: " 
    + manufactureDate.format(dtf) 
    + ")";
  }

}