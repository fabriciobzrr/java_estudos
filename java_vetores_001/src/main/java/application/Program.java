package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int N = sc.nextInt();
        double[] vet = new double[N];

        double total = 0;
        for (int i = 0; i < vet.length; i++) {
            System.out.print("Altura " + (i + 1) + ": ");
            vet[i] = sc.nextDouble();
            total = total + vet[i];
        }
        double media = total / vet.length;
        System.out.println("Média: " + media);



        sc.close();
    }
}
