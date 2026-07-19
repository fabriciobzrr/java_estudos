package entities;

public enum OrderStatus {

    PENDING("Pendente"),
    DELIVERED("Entregue");

    public final String description;

    OrderStatus(String description) {
        this.description = description;
    }
}
