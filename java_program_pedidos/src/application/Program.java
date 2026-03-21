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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        IO.println("Informe os dados do cliente:");
        IO.print("Nome: ");
        String name = sc.nextLine();
        IO.print("Email: ");
        String email = sc.next();
        IO.print("Data de Nascimento (DD/MM/YYYY): ");
        LocalDate birthDate = LocalDate.parse(sc.next(), dtf);

        Client client = new Client(name, email, birthDate);

        IO.println();
        IO.print("Deseja cadastrar um pedido? (s/n) ");
        char answer = sc.next().charAt(0);
        while (answer != 's' && answer != 'n') {
            IO.println();
            IO.println("Escolha inválida! Tente novamente!");
            IO.println();
            IO.print("Deseja cadastrar um pedido? (s/n) ");
            answer = sc.next().charAt(0);
        }

        while (answer == 'n') {
            IO.println();
            IO.println("Nenhum pedido cadastrado!");
            return;
        }

        IO.println();
        IO.print("Informe o status do pedido: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(LocalDateTime.now(), status, client);

        IO.println();
        IO.println("Informe os dados do pedido abaixo:");
        int count = 0;
        while (answer == 's') {
            count++;
            IO.println();
            IO.println("Item #" + count + ":");
            IO.print("Nome do produto: ");
            sc.nextLine();
            String productName = sc.nextLine();
            IO.print("Preço do produto: ");
            double productPrice = sc.nextDouble();
            IO.print("Quantidade: ");
            int productQuantity = sc.nextInt();

            Product product = new Product(productName, productPrice);

            OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);

            order.addItem(orderItem);

            IO.println();
            IO.print("Deseja cadastrar mais um item? (s/n) ");
            answer = sc.next().charAt(0);

            while (answer != 's' && answer != 'n') {
                IO.println();
                IO.println("Escolha inválida! Tente novamente!");
                IO.println();
                IO.print("Deseja cadastrar mais um item? (s/n) ");
                answer = sc.next().charAt(0);
            }
        }

        IO.println();
        IO.println("---------------------------------------");
        IO.println(order);
        IO.println("---------------------------------------");

        sc.close();
    }
}
