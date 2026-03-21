package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        File file = new File("D:\\projects\\meuarquivo.txt");
        Scanner sc = null;
        try {
            if (file.createNewFile()) {
                IO.println("Arquivo criado com sucesso! " + file.getName());
            } else {
                IO.println("Arquivo já existente! " + file.getName());
            }

            IO.println("Caminho absoluto: " + file.getAbsolutePath());
            IO.println("Possivel ler: " + file.canRead());
            IO.println("Tamanho: " + file.length());
        } catch (IOException e) {
            IO.println("Erro: " + e.getMessage());
        }
    }
}
