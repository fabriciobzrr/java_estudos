package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        IO.println("----------------------------------------");
        IO.println("Entre com os dados do cliente:");
        IO.print("Nome: ");
        String name = sc.nextLine();
        IO.print("Email: ");
        String email = sc.nextLine();
        IO.print("Data de nascimento: ");
        LocalDate dateBirth = LocalDate.parse(sc.next(), dtf);

        Client client = new Client(name, email, dateBirth);

        IO.println();
        IO.println("----------------------------------------");
        IO.println("Entre com os dados do pedido:");
        IO.print("Status do pedido: ");
        OrderStatus status = OrderStatus.valueOf(sc.next().toUpperCase());


        LocalDateTime orderDate = LocalDateTime.now();
        Order order = new Order(orderDate, status, client);

        IO.print("Quantos itens tem o pedido? ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            IO.println();
            IO.println("----------------------------------------");
            IO.println("Dados do item #" + i + ":");
            IO.print("Nome do produto: ");
            sc.nextLine();
            String nameProduct = sc.nextLine();
            IO.print("Preço do produto: ");
            Double priceProduct = sc.nextDouble();

            Product product = new Product(nameProduct, priceProduct);

            IO.print("Quantidade: ");
            Integer quantityProduct = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantityProduct, priceProduct, product);
            order.addItem(orderItem);
        }
        IO.println("----------------------------------------");
        IO.print(order);
        IO.println("----------------------------------------");

        sc.close();
    }
}
