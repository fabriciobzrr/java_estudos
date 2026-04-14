package services;

import entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CalcService {

    private final List<Product> products;

    public CalcService() {
        products = new ArrayList<>();
    }

    public void adicionarProdutos(Product product) {
        products.add(product);
    }

    public List<Product> listarTodos() {
        return new ArrayList<>(products);
    }

    public double calcularMedia() {
        return products.stream()
                .mapToDouble(p -> p.getPrice())
                .sum() / products.size();
    }

    public List<Product> menorParaMaior() {
        return products.stream()
                .sorted((p1, p2) -> p2.getName().toLowerCase().compareTo(p1.getName().toLowerCase()))
                .collect(Collectors.toList());
    }
}
