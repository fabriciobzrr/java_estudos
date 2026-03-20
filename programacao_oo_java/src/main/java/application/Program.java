package application;

import entities.Triangle;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Triangle x, y;
        x = new Triangle();
        y = new Triangle();

        double xA, xB, xC, yA, yB, yC;

        System.out.print("X lado A: ");
        x.a = sc.nextDouble();
        System.out.print("X lado B: ");
        x.b = sc.nextDouble();
        System.out.print("X lado C: ");
        x.c = sc.nextDouble();
        System.out.print("Y lado A: ");
        y.a = sc.nextDouble();
        System.out.print("Y lado B: ");
        y.b = sc.nextDouble();
        System.out.print("Y lado C: ");
        y.c = sc.nextDouble();

        double areaX = x.calcArea();
        double areaY = y.calcArea();

        System.out.printf("Area de X: %.2f%n", areaX);
        System.out.printf("Area de Y: %.2f%n", areaY);

        if (areaX > areaY) {
            System.out.println("Maior area é do X");
        } else {
            System.out.println("Maior area é do Y ");
        }

        sc.close();
    }
}
