package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> courseA = new HashSet<>();
        Set<Integer> courseB = new HashSet<>();
        Set<Integer> courseC = new HashSet<>();

        IO.print("Quantos estudantes matrículados no curso A? ");
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            IO.print("ID: ");
            Integer id = sc.nextInt();
            courseA.add(id);
        }
        IO.print("Quantos estudantes matrículados no curso B? ");
        number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            IO.print("ID: ");
            Integer id = sc.nextInt();
            courseB.add(id);
        }
        IO.print("Quantos estudantes matrículados no curso C? ");
        number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            IO.print("ID: ");
            Integer id = sc.nextInt();
            courseC.add(id);
        }

        Set<Integer> conj = new HashSet<>(courseA);
        conj.addAll(courseB);
        conj.addAll(courseC);

        IO.println();
        IO.println("Total de alunos: " + conj.size());
    }
}
