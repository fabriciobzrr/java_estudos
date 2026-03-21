package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String name = sc.nextLine();

        System.out.println("Olá, " + name + "!");
        System.out.println("Seja bem-vindo!");

        sc.close();
    }
}
