package application;

import model.entities.Account;
import model.exceptions.BusinessException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        IO.println("Informe os dados da conta:");
        IO.print("Número: ");
        Integer number = sc.nextInt();
        IO.print("Titular: ");
        sc.nextLine();
        String holder = sc.nextLine();
        IO.print("Deposito inicial: ");
        Double depositValue = sc.nextDouble();
        IO.print("Limite de saque: ");
        Double withdrawLimit = sc.nextDouble();

        Account acc = new Account(number, holder, depositValue, withdrawLimit);

        IO.println();
        IO.print("Informe o valor a sacar: ");
        Double withdrawValue = sc.nextDouble();

        try {
            acc.withdraw(withdrawValue);
            IO.print("Novo saldo: " + String.format("%.2f", acc.getBalance()));
        } catch (BusinessException e) {
            IO.println("Erro ao sacar: " + e.getMessage());
        }

        sc.close();
    }
}
