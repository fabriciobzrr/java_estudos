package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        Account acc2 = new SavingsAccount(102, "Fred", 1000.0, 0.01);
        Account acc3 = new BusinessAccount(103, "Billy", 1000.0, 500.0);

        accounts.add(acc2);
        accounts.add(acc3);

        double tot = 0;
        for(Account a : accounts) {
            tot += a.getBalance();
        }
        IO.println(tot);

    }
}
