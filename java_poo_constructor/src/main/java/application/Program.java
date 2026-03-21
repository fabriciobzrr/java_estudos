package application;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;
import entities.Product;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product data:");
        System.out.print("Name: ");
        String name = sc.next().toUpperCase();
        System.out.print("Price: ");
        double price = sc.nextDouble();
/*        System.out.print("Quantity: ");
        int quantity = sc.nextInt();*/
        Product product = new Product(name, price);

        product.setName("Tablet");
        System.out.println(product.getName());

        System.out.println();
        System.out.println("Product data: " + product);

        System.out.println();
        System.out.print("Enter the number of products to be added in stock: ");
        int quantity = sc.nextInt();
        product.addProducts(quantity);

        System.out.println();
        System.out.println("Updated data: " + product);

        System.out.println();
        System.out.print("Enter the number of products to be added in stock: ");
        product.removeProducts(sc.nextInt());

        System.out.println();
        System.out.println("Updated data: " +  product);

        sc.close();
    }
}
