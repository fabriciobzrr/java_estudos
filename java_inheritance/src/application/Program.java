package application;

import entities.Account;
import entities.BusinessAcount;
import entities.SavingsAccount;

public class Program {
  public static void main(String[] args) {
    Account acc = new Account(101, "Fred", 3000.00);
    BusinessAcount bacc = new BusinessAcount(102, "Bob", 0.00, 500.00);

    // Upcasting
    Account acc2 = bacc;
    Account acc3 = new BusinessAcount(103, "Charlie", 0.00, 500.00);
    Account acc4 = new SavingsAccount(104, "Greg", 0.00, 100.00);

    // Downcasting
    BusinessAcount acc5 = (BusinessAcount) acc3;
    acc5.loan(200.00);
    acc5.withdraw(300.00);
    acc5.deposit(400.00);

    // SavingsAccount (acc4) não pode ser convertido para BusinessAcount (acc6)
    // BusinessAcount acc6 = (BusinessAcount) acc4; 

  }
}
