package model.services;

import model.entities.Product;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    public static double filterPrice(List<Product>list, Predicate<Product> filter) {
        double total = 0.0;
        for (Product p : list) {
            if (filter.test(p)) {
                total += p.getPrice();
            }
        }
        return total;
    }
}
