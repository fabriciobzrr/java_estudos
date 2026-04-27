package application;

import entities.Product;

import java.util.*;

public class Program {
    public static void main (String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("TV", 900.00));
        products.add(new Product("Notebook", 1200.00));
        products.add(new Product("Tablet", 450.00));

        // Comparator com declaração de classe
//        products.sort(new MyComparator());

        // Comparator com função anônima
//        Comparator<Product> comp = new Comparator<Product>() {
//            @Override
//            public int compare(Product p1, Product p2) {
//                return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
//            }
//        };

//        products.sort(comp);

        // Comparator com arrow function
        Comparator<Product> comp = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());

        // Comparator com arrow function no argumento
        products.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));


        for (Product p : products) {
            IO.println(p);
        }

        MyRunnable r1 = new MyRunnable();
        r1.run();
        new MyRunnable().run();
        Runnable r2 = () -> IO.println("Fumo Noites");
        r2.run();
    }
}

