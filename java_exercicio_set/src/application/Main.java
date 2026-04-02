package application;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> students = new HashSet<>();
        List<String> course = Arrays.asList("A", "B", "C");

        for (String item : course) {
            IO.print("Quantos alunos inscritos no curso " + item + "? ");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                IO.print("ID: ");
                Integer ids = sc.nextInt();
                students.add(ids);
            }
        }
        IO.println("Total de alunos: " + students.size());

        sc.close();
    }
}
