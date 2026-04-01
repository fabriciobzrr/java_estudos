package application;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TesteIgualdade {
    public static void main(String[] args) {
        Set<Product> product = new HashSet<>();

        product.add(new Product("TV", 900.0));
        product.add(new Product("Notebook", 1200.0));
        product.add(new Product("Tablet", 500.0));

        Product prod = new Product("Notebook", 1200.0);

        IO.println(product.contains(prod)); // true pois foram implementados o hashCode e o equals para testar igualdade
    }
}

class Product implements Comparable<Product> {
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return name + " - " + String.format("%.2f", price);
    }

    @Override
    public int compareTo(Product o) {
        return price.compareTo(o.getPrice());
    }
}
