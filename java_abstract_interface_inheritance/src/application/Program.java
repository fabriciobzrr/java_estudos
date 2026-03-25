package application;

import entities.AbstractShape;
import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        AbstractShape circle = new Circle(Color.RED, 5.0);
        AbstractShape rectangle = new Rectangle(Color.BLACK, 3.0, 4.0);

        IO.println("AREA DO CIRCULO:");
        IO.println("COR: " + circle.getColor());
        IO.print("AREA: ");
        IO.println(String.format("%.2f", circle.area()));

        IO.println();
        IO.println("AREA DO RETANGULO");
        IO.println("COR: " + rectangle.getColor());
        IO.print("AREA: ");
        IO.println(String.format("%.2f", rectangle.area()));
    }
}
