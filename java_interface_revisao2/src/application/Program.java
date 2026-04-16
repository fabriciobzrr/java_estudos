package application;

import entities.Product;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        List<Product> produtos = new ArrayList<>();
        produtos.add(new Product("Mouse", 50.00));
        produtos.add(new Product("Teclado", 150.00));
        produtos.add(new Product("Monitor", 800.00));

        List<Product> prod = produtos.stream()
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .toList();

        // ANTES da ordenação
        System.out.println(produtos);

        // ORDENA usando o compareTo que definimos!
        Collections.sort(produtos);

        // DEPOIS da ordenação
        System.out.println(produtos);
        System.out.println(prod);
        LocalDateTime d1 =  LocalDateTime.now();
        LocalDateTime d2 =  LocalDateTime.parse("24/04/2026 11:30");
        long date = d1.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long time = Duration.between(d1, d2).toMillis();
    }
}
