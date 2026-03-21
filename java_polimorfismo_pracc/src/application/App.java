package application;
import entities.Account;
import entities.SavingsAccount;

public class App {
    public static void main(String[] args) throws Exception {
       
        Account x = new Account(1001, "Alex", 1000.0);
        Account y = new SavingsAccount(1002, "Maria", 1000.0, 0.01);

        x.withdraw(100.00);
        y.withdraw(100.00);

        IO.println(x.getBalance());
        IO.println(y.getBalance());
    }
}
