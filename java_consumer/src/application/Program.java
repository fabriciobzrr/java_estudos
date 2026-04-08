package application;

import model.entities.Product;
import util.PriceUpdate;
import util.PriceUpdate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        // Padrão criação de classes (Product e PriceUpdate) e instanciação dos objetos para execução do método
//        PriceUpdate priceUpdate = new PriceUpdate();
//        for (Product product : list) {
//            priceUpdate.accept(product);
//        }
//        for (Product product : list) {
//            IO.println(product.getPrice());
//        }

        // Implementação de interface e declaração no argumento do método
//        list.forEach(new PriceUpdate());
//        list.forEach(IO::println);

        // Método estático, chamado pela propria classe
//        list.forEach(Product::staticPriceUpdate);
//        list.forEach(IO::println);

        // Método não estático, precisa ser chamado pela instância do objeto
//        list.forEach(Product::nonStaticPriceUpdate);
//        list.forEach(IO::println);

        // Expressão lambda declarada em uma variável no programa principal
//        Consumer<Product> consumer = product -> product.setPrice(product.getPrice() * 1.1);
//        list.forEach(consumer);
//        list.forEach(IO::println);

        // Expressão lambda inline - chamada por parâmetro direto no argumento da função
        list.forEach(product -> product.setPrice(product.getPrice() * 1.1));
        list.forEach(IO::println);


    }

}