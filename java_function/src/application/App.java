package application;

import model.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        for (Product p : list) {
            System.out.println(p.getName().toUpperCase());
        }

        System.out.println();

        List<String> lista1 = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());
        lista1.forEach(System.out::println);

        System.out.println();

        List<String> lista2 = list.stream().map(Product::staticUpperCaseName).toList();
        lista2.forEach(System.out::println);
    }
}
