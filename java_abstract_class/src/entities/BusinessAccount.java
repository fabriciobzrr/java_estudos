package entities;

public class BusinessAccount extends Account{

  private Double loanLimit;

  public BusinessAccount() {
    super();
  }

  public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
    super(number, holder, balance);
    this.loanLimit = loanLimit;
  }

  public Double getLoanLimit() {
    return loanLimit;
  }

  public void setLoanLimit(Double loanLimit) {
    this.loanLimit = loanLimit;
  }

  public void loan(Double value) {
    if (value <= loanLimit) {
      balance += value - 10.0;
    }
  }

  @Override
  public final void withdraw(Double value) {
    super.withdraw(value);
    balance -= 2.0;
  }
  
}
