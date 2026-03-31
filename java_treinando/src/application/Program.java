package application;

import java.util.Scanner;

public class Program {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        String correctUser = "admin";
        String correctPass = "1234";

        while (true) {
            System.out.print("Usuário: ");
            String username = sc.nextLine();
            System.out.print("Senha: ");
            String password = sc.nextLine();
            if (correctUser.equals(username) && correctPass.equals(password)) {
                break;
            }
            System.out.println("Usuário ou senha inválidos\n");
        }
        System.out.println("Login realizado com sucesso\n");
        sc.close();
    }
}
