package model.entities;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Método estático - Pertence a classe, não ao objeto - não deve ser instanciado para utilizar
    public static void staticPriceUpdate(Product product) {
        product.setPrice(product.getPrice() * 1.1);
    }

    // Método não estático - Pertence ao objeto, precisando ser instanciado para utilizar
    public void nonStaticPriceUpdate() {
        setPrice(getPrice() * 1.1);
    }

    @Override
    public String toString() {
        return name + ", " + String.format("%.2f", price);
    }
}
