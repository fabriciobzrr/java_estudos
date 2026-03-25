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
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        List<Shape> list = new ArrayList<>();

        IO.print("Digite o número de formas: ");
        int number = sc.nextInt();

        for (int i = 0; i < number; i++) {
            IO.println();
            IO.println("Dados da forma #" + (i + 1) + ":");
            IO.println();

            IO.println("Escolha uma opção:");
            IO.println("1 - Retângulo");
            IO.println("2 - Circulo");
            IO.println("3 - Pular");
            IO.println("0 - Finalizar");
            IO.print("Opção: ");
            int option = sc.nextInt();

            Color color;

            switch (option) {
                case 0:
                    IO.println("Finalizando...");
                    return;
                case 1:
                    IO.println("Retângulo");
                    IO.println();
                    break;
                case 2:
                    IO.println("Circulo");
                    IO.println();
                    break;
                case 3:
                    IO.println("Próximo...");
                    IO.println();
                    break;
                default:
                    while (option != 1 && option != 2){
                        IO.println("Opção inválida!");
                        IO.println("Escolha uma opção:");
                        IO.println("1 - Retângulo");
                        IO.println("2 - Circulo");
                        IO.println("9 - Pular");
                        IO.println("0 - Finalizar");
                        IO.print("Opção: ");
                        option = sc.nextInt();
                        if (option == 0) {
                            return;
                        }
                    }
                    break;

            }

            AbstractShape shape;

            switch (option) {
                case 1:
                    IO.print("Cor: (BLACK/BLUE/RED) ");
                    color = Color.valueOf(sc.next().toUpperCase());
                    IO.print("Largura: ");
                    Double width = sc.nextDouble();
                    IO.print("Altura: ");
                    Double height = sc.nextDouble();

                    shape = new Rectangle(color, width, height);

                    list.add(shape);

                    break;
                case 2:
                    IO.print("Cor: (BLACK/BLUE/RED) ");
                    color = Color.valueOf(sc.next().toUpperCase());
                    IO.print("Raio: ");
                    Double radius = sc.nextDouble();

                    shape = new Circle(color, radius);

                    list.add(shape);

                    break;
            }
        }

        IO.println();
        IO.println("AREAS DAS FORMAS:");
        for (Shape s : list) {
            IO.println(String.format("%.2f", s.area()));
        }
        sc.close();
    }
}
