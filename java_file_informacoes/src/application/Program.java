package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main (String[] args) {
        String nameFolder = "java";
        String txtPath = "D:" + File.separator + "Projects-Java" + File.separator + nameFolder;
        File path = new File(txtPath);
        IO.println();
        IO.println("Nome: " + path.getName());
        IO.println("Caminho da Pasta: " + path.getParent());
        IO.println("Caminho do Arquivo: " + path.getPath());

    }
}
