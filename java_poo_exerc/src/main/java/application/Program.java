package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int accNumber = sc.nextInt();

        System.out.print("Enter account holder name: ");
        sc.nextLine();
        String holderName = sc.nextLine();

        System.out.print("Is there an initial deposit? (y/n) ");
        char hasDeposit = sc.next().charAt(0);

        Account account;

        if (hasDeposit == 'y') {
            System.out.println();
            System.out.print("Enter initial deposit value: ");
            double initialDeposit = sc.nextDouble();
            account = new Account(accNumber, holderName, initialDeposit);
        } else {
            account = new Account(accNumber, holderName);
            System.out.println();
        }

        System.out.println("Account data:");
        System.out.println(account);

        System.out.print("Do you wish to perform another operation? (y/n) ");
        char newOperation = sc.next().charAt(0);
        if (newOperation == 'y') {
            System.out.println("Type:");
            System.out.println("1 - for deposit");
            System.out.println("2 - for withdraw");
            System.out.println("3 - for balance");
            System.out.println("0 - exit");
            System.out.print("Choice operation: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Enter deposit value: ");
                double deposit = sc.nextDouble();
                account.deposit(deposit);
            } else if (choice == 2) {
                if (account.getAmount() > 0) {
                    System.out.println("Enter withdraw value: ");
                    double withdraw = sc.nextDouble();
                    if (account.getAmount() > withdraw) {
                        account.withdraw(withdraw);
                    } else {
                        System.out.println("Insufficient funds!");
                    }

                } else {
                    System.out.println("Insufficient funds");
                }
            } else if (choice == 3) {
                System.out.println("Account data:");
                System.out.println(account);
            } else if (choice == 0) {
                return;
            } else {
                System.out.println("Invalid operation!");
            }

            System.out.println("Updated account data:");
            System.out.println(account);

        }

        sc.close();
    }
}
