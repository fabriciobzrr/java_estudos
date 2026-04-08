package application;

import model.entities.Product;
import util.UpperCaseName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        // Implementando a inferface
//        List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());
//        names.forEach(System.out::println);

        // Método estático chamado diretamente pela classe Product
//        List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());
//        names.forEach(System.out::println);

        // Método não estático chamado pela instância do objeto
//        List<String> names = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());
//        names.forEach(System.out::println);

        // Expressão lambda declarada numa variável
//        Function<Product, String> func = product -> product.getName().toUpperCase();
//        List<String> names = list.stream().map(func).collect(Collectors.toList());
//        names.forEach(System.out::println);

        // Expressão lambda inline - direto no argumento
        List<String> names = list.stream().map(product -> {
            return product.getName().toUpperCase();
        }).collect(Collectors.toList());
        names.forEach(System.out::println);

    }

}