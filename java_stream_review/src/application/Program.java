package application;

import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main (String[] args) {

        List<Product> products = new ArrayList<>();

        String path = "in.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                Double price = Double.parseDouble(fields[1]);
                products.add(new Product(name, price));
                line = br.readLine();
            }

            double total = products.stream()
                    .mapToDouble(Product::getPrice)
                    .sum() ;

            double media;
            if (!products.isEmpty()) {
                media = total / products.size();
            } else {
                media = 0.0;
                IO.println("Nenhum objeto na lista!");
            }

            Comparator<String> comp = (s1, s2) -> s1.toLowerCase().compareTo(s2.toLowerCase());

            List<String> names = products.stream()
                    .filter(p -> p.getPrice() < media)
                    .map(Product::getName)
                    .sorted(comp.reversed())
                    .collect(Collectors.toList());

            IO.println("Média: R$ " + String.format("%.2f", media));
            names.forEach(IO::println);

        } catch (IOException err) {
            IO.println("Erro: " + err.getMessage());
        }
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
    public int compareTo(Product o) {
        return name.toUpperCase().compareTo(o.name.toUpperCase());
    }
}
