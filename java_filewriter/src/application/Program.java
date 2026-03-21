package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main (String[] args) {
        String frase = "Bom dia, Boa tarde, Boa noite";
        String[] texto = frase.split(", ");

        String caminho = "D:\\Projects-Java\\out.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (String line : texto) {
                bw.write(line + "\n");
            }
        } catch (IOException e) {
            IO.println("Erro: " + e.getMessage());
        }
    }
}
