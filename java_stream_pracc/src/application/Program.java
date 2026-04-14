package application;

import entities.Product;
import services.CalcService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    private static final Scanner sc = new Scanner(System.in);
    private static final CalcService calcService = new CalcService();
    public static void main (String[] args) {
        Locale.setDefault(Locale.US);
        IO.print("Caminho do arquivo .csv: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);

                calcService.adicionarProdutos(new Product(name, price));
                line = br.readLine();
            }

            List<Product> filtrados = calcService.menorParaMaior();

            double media = calcService.calcularMedia();
            IO.println("Média de Preço: R$ " + String.format("%.2f", media));
            for (Product p : filtrados) {
                if (p.getPrice() < media) {
                    IO.println(p.getName());
                }
            }

        } catch (IOException err) {
            IO.println("Erro: " + err.getMessage());
        }

        sc.close();
    }
}
