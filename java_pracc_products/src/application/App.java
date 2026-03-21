package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class App {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        IO.print("Digite o número de produtos: ");
        int number = sc.nextInt();

        for (int i = 1; i <= number; i++) {
            IO.println();
            IO.println("Produto #" + i + ":");
            IO.println("Escolha uma das opções abaixo:");
            IO.println("1 - Produto comum");
            IO.println("2 - Produto usado");
            IO.println("3 - Produto importado");

            IO.print("Opção: ");
            int option = sc.nextInt();
            if (option == 1) {
                IO.println("COMUM selecionado");
            }
            if (option == 2) {
                IO.println("USADO selecionado");
            }
            if (option == 3) {
                IO.println("IMPORTADO selecionado");
            }
            
            IO.print("Nome do produto: ");
            sc.nextLine();
            String name = sc.nextLine();

            IO.print("Preço do produto: ");
            double price = sc.nextDouble();
            
            Product product;

            switch (option) {
                case 1:
                    product = new Product(name, price);
                    list.add(product);
                    break;

                case 2:
                    IO.print("Data de fabricação (DD/MM/YYYY): ");
                    LocalDate manufacturedDate = LocalDate.parse(sc.next(), dtf);
                    product = new UsedProduct(name, price, manufacturedDate);
                    list.add(product);
                    break;

                case 3:
                    IO.print("Taxa de importação: ");
                    double customsFee = sc.nextDouble();
                    product = new ImportedProduct(name, price, customsFee);
                    list.add(product);
                    break;

                default:
                    IO.println("Opção inválida!");
                    break;
            }
            
        }

        IO.println();
        IO.println("===============================================");
        IO.println("ETIQUETAS DE PREÇO:");
        for (Product product : list) {
            IO.println(product.priceTag());
        }
        IO.println("===============================================");




        sc.close();
    }
}
