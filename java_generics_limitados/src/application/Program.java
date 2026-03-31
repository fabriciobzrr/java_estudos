package application;

import model.entities.Product;
import model.services.CalculationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main (String[] args) {
        List<Product> list = new ArrayList<>();
        String path = "D:\\Projects-Java\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] items = line.split(",");
                String name = items[0];
                Double price = Double.parseDouble(items[1]);
                list.add(new Product(name, price));
                line = br.readLine();
            }

            Product x = CalculationService.max(list);
            System.out.println("Max:");
            System.out.println(x);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
