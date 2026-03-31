package application;

import model.services.PrintService;

import java.util.Scanner;

public class Program {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        PrintService<String> printService = new PrintService<>();

        IO.print("Valores? ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            IO.print("Valor: ");
            String value = sc.next();
            printService.addValue(value);
        }

        printService.print();
        IO.println();
        String res = printService.first();
        IO.println("Primeiro valor: " + res);

        sc.close();

    }
}
