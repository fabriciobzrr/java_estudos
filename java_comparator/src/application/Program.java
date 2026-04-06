package application;

import model.entities.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Program {
    public static void main (String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 899.99));
        list.add(new Product("Notebook", 1299.99));
        list.add(new Product("Tablet", 499.99));

        // compareTo com Comparable<T>
//        Collections.sort(list);

        // compare com Comparator
//        list.sort(new MyComparator());

        // como anonymous function
//        Comparator<Product> comp = new Comparator<Product>() {
//            @Override
//            public int compare(Product p1, Product p2) {
//                return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
//            }
//        };
//        list.sort(comp);

        // como arrow function
//        Comparator<Product> comp = (p1, p2) -> {
//            return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
//        };
//        list.sort(comp);


        // como arrow function resumida
//        Comparator<Product> comp = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
//        list.sort(comp);

        // como arrow function resumida como parâmetro
        list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

        for (Product item : list) {
            System.out.println(item);
        }

    }
}
