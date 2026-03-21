package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main (String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String caminho = "D:\\Projects-Java\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha = br.readLine();

            while (linha != null) {
                IO.println(linha);
                linha = br.readLine();
            }
        } catch (IOException e) {
            IO.println("Erro: " + e.getMessage());
        }
        sc.close();
    }
}
