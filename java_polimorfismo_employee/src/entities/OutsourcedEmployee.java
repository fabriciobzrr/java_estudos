package entities;

public final class OutsourcedEmployee extends Employee {
  private Double additionalCharge;

  public OutsourcedEmployee() {
    super();
  }

  public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
    super(name, hours, valuePerHour);
    this.additionalCharge = additionalCharge;
  }

  public Double getAdditionalCharge() {
    return additionalCharge;
  }

  public void setAdditionalCharge(Double additionalCharge) {
    this.additionalCharge = additionalCharge;
  }

  @Override
  public Double payment() {
    return super.payment() + additionalCharge * 110 / 100;
  }

  @Override
  public String toString() {
    return super.getName() + ", horas trabalhadas: " + super.getHours() + "h, valor por hora: R$" + String.format("%.2f", super.getValuePerHour()) + ", custos adicionais: R$" + String.format("%.2f",payment() - super.getHours() * super.getValuePerHour())  + "." + " Totalizando: " + String.format("%.2f", payment());
  }
}
