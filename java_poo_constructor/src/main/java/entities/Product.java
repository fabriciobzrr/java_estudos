package entities;

public class Product {
    private String name;
    private double price;
    private int quantity;

    // Construtor padrão - permite instanciar novos objetos sem dados iniciais.
    public Product () {
    }

    // Construtor personalizado - permite instanciar novos objetos com valores desejados.
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Sobrecarga - permite instanciar novos objetos com valores e alguns com valor padrão.
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters e Setters
    // Getter - são usados para pegar os dados de um atributo encapsulado (private)
    // Setter - são usados para definir valores de um atributo encapsulado (private)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    public int getQuantity () {
        return quantity;
    }

    /*public void setQuantity (int quantity) {
        this.quantity = quantity;
    }*/

    // Método que calcula o valor total em estoque
    public double totalValueInStock() {
        return price * quantity;
    }

    // Método que adiciona quantidade desejada do estoque
    public void addProducts(int quantity) {
        this.quantity += quantity;
    }

    // Método que remove quantidade desejada do estoque
    public void removeProducts(int quantity) {
        this.quantity -= quantity;
    }

    // Imprime as informações do objeto na tela... toString().
    public String toString() {
        return name
                + ", $ "
                + String.format("%.2f", price)
                + ", "
                + quantity
                + " units, Total: $ "
                + String.format("%.2f", totalValueInStock());
    }
}
