package application;

import model.entities.BrazilInterestService;
import model.entities.InterestService;
import model.entities.UsaInterestService;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Valor: ");
        double amount = sc.nextDouble();
        System.out.print("Meses: ");
        int months = sc.nextInt();

        InterestService us = new UsaInterestService(1.0);
        InterestService br = new BrazilInterestService(2.0);
        double payment = us.payment(amount, months);

        if (months == 1) {
            System.out.println("Pagamento após " + months + " mês:");
            System.out.println(String.format("%.2f", payment));
        } else {
            System.out.println("Pagamento após " + months + " meses:");
            System.out.println(String.format("%.2f", payment));
        }

        sc.close();
    }
}
