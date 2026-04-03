package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> regs = new HashMap<>();

        IO.print("Digite o caminho do arquivo: ");
        String file = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                Integer votes = Integer.parseInt(fields[1]);

                if (!regs.containsKey(name)) {
                    regs.put(name, votes);
                } else {
                    Integer counter = regs.get(name);
                    regs.put(name, counter + votes);
                }

                line = br.readLine();
            }

            IO.println("\n====================");
            IO.println("Contagem de votos:");
            for (String item : regs.keySet()) {
                IO.println(item + ": " + regs.get(item));
            }
            IO.println("====================");

        } catch (IOException e) {
            IO.println("Erro: " + e.getMessage());
        }

        sc.close();

    }
}
