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
    public static String staticUpperCaseName(Product product) {
        return product.getName().toUpperCase();
    }

    // Método não estático - Pertence ao objeto, precisando ser instanciado para utilizar
    public String nonStaticUpperCaseName() {
        return getName().toUpperCase();
    }

    @Override
    public String toString() {
        return name + ", " + String.format("%.2f", price);
    }
}
