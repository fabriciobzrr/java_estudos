package application;

import model.entities.Product;
import util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        // Implementação de interface
        list.removeIf(new ProductPredicate());

        // Método estático - Pertence a classe, não ao objeto - não deve ser instanciado para utilizar
        list.removeIf(Product::staticPredicate);

        // Método não estático - Pertence ao objeto, precisando ser instanciado para utilizar
        list.removeIf(Product::nonStaticPredicate);

        // Expressão lambda declarada no programa principal dentro de uma variável
        Predicate<Product> pred = product -> product.getPrice() < 100.00;
        list.removeIf(pred);

        // Expressão lambda inline - passada diretamente como argumento
        list.removeIf(product -> product.getPrice() < 100.00);

        list.forEach(IO::println);

    }

}