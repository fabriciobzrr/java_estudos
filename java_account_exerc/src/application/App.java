package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class App {
    public static void main(String[] args) throws Exception {
        Account acc1 = new Account(100, "Fred", 2000.0);
        acc1.withdraw(100.0);
        IO.println(acc1.getBalance());

        Account acc2 = new SavingsAccount(101, "Jay", 2000.00, 0.05);
        acc2.withdraw(100.0);
        IO.println(acc2.getBalance());

        Account acc3 = new BusinessAccount(102, "Jerry", 2000.00, 1000.00);
        acc3.withdraw(100.0);
        IO.println(acc3.getBalance());
    }
}
