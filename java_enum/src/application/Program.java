package application;

import entities.Order;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer id = sc.nextInt();
        LocalDate moment = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Order order = new Order(id , moment, OrderStatus.PROCESSING);
        System.out.println(order);

        OrderStatus status = OrderStatus.PROCESSING;
        OrderStatus status2 = OrderStatus.valueOf("PROCESSING");
        System.out.println(status);
        System.out.println(status2);

        sc.close();
    }
}
