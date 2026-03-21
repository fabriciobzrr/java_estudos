package entities;

public class Account {
    private int accNumber;
    private String holderName;
    private double amount;

    public Account() {
    }

    public Account(int accNumber, String holderName, double initialDeposit) {
        this.accNumber = accNumber;
        this.holderName = holderName;
        deposit(initialDeposit);
    }

    public Account(int accNumber, String holderName) {
        this.accNumber = accNumber;
        this.holderName = holderName;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getAmount() {
        return amount;
    }

    public void deposit (double value) {
        amount += value;
    }

    public void withdraw (double value) {
        amount -= value + 5.0;
    }

    @Override
    public String toString() {
        return "Account " + accNumber + ", Holder: " + holderName + ", Balance: $ " + String.format("%.2f", amount);
    }
}
