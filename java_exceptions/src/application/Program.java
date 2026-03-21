package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        method1();
        IO.println("Fim do programa");
    }

    public static void method1() {
        IO.println("===========1===========");
        method2();
        IO.println("===========1===========");

    }

    public static void method2() {
        IO.println("===========2===========");
        Scanner sc = new Scanner(System.in);
        try {
            String[] names = sc.nextLine().split(" ");
            int pos = sc.nextInt();
            IO.println(names[pos]);
        } catch (ArrayIndexOutOfBoundsException e) {
            IO.println("Erro 1");
            e.printStackTrace();
            sc.next();
        } catch (InputMismatchException err) {
            IO.println("Erro 2");
        }
        sc.close();
        IO.println("===========2===========");
    }
}
