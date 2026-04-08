package application;

import model.entities.Product;
import model.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Program {
    public static void main (String[] args) {
        List<Product> list = new ArrayList<>();

        var nome = "Fred";

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 100.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        double sum = ProductService.filterPrice(list, p -> p.getPrice() > 10.0);

        System.out.println(String.format("%.2f", sum));
    }
}
