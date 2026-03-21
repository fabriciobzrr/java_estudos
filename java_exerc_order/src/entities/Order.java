package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private LocalDateTime moment;
    private OrderStatus status;
    private Client client;

    private List<OrderItem> items = new ArrayList<>();

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double total() {
        double total = 0.0;
        for(OrderItem item : items) {
            total += item.subTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data do pedido: ");
        sb.append(moment.format(dtf) + "\n");

        sb.append("Status do pedido: ");
        sb.append(status + "\n");
        sb.append("Dados do Cliente: " + client + "\n");
        sb.append("\n");

        sb.append("Itens do pedido: \n");
        for(OrderItem item : items) {
            sb.append(item +"\n");
        }
        sb.append("Total do pedido: $" + String.format("%.2f", total()) + "\n");


        return sb.toString();
    }
}
