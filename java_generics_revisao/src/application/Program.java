package application;

import entities.Product;
import services.CalculationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    private static final Scanner sc = new Scanner(System.in);
    public static void main (String[] args) throws IOException {
        List<Product> lista = new ArrayList<>();

        String caminho = "in.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                lista.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            Product product = CalculationService.max(lista);
            IO.println("MAX: " + product);
        }


        sc.close();
    }
}
















