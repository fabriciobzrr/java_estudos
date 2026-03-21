package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        File file = new File("C:\\tmp\\in.txt");
        Scanner sc = null;

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                IO.println(sc.nextLine());
            }
        } catch (FileNotFoundException err) {
            IO.println("Erro ao abrir arquivo: " + err.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
            IO.println("Fim do arquivo");
        }

    }
}
