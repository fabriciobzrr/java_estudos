package application;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TesteTreeSet {
    public static void main(String[] args) {

        Set<Product> product = new TreeSet<>();

        product.add(new Product("TV", 900.0));
        product.add(new Product("Notebook", 1200.0));
        product.add(new Product("Tablet", 500.0));

        for (Product prod : product) {
            IO.println(prod);
        }

    }
}