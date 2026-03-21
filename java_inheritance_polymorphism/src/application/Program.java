package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        IO.print("Digite com o número de contribuintes: ");
        int number = sc.nextInt();

        for (int i = 1; i <= number; i++) {
            IO.println();
            IO.println("Contribuinte #" + i + ":");
            IO.println("Pessoa fisica ou jurídica? (f/j) ");
            IO.print("Opção: ");
            char answer = sc.next().charAt(0);

            if (answer == 'f') {
                IO.print("Nome: ");
                sc.nextLine();
                String name = sc.nextLine();
                IO.print("Renda anual: ");
                Double anualIncome = sc.nextDouble();
                IO.print("Gastos com saúde: ");
                Double healthExpenditures = sc.nextDouble();

                list.add(new Individual(name, anualIncome, healthExpenditures));
            } else {
                IO.print("Nome: ");
                sc.nextLine();
                String name = sc.nextLine();
                IO.print("Renda anual: ");
                Double anualIncome = sc.nextDouble();
                IO.print("Numero de funcionários: ");
                int numberOfEmployees = sc.nextInt();

                list.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }

        IO.println();
        IO.println("Taxas Pagas:");
        Double total = 0.0;
        for (TaxPayer payer : list) {
            IO.println(payer.getName() + ": R$ " + String.format("%.2f", payer.tax()));
            total += payer.tax();
        }
        IO.println();
        IO.println("Total de taxas pagas: " + String.format("%.2f", total));

        sc.close();
    }
}
