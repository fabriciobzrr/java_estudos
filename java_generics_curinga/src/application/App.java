package application;

import model.entities.Circle;
import model.entities.Rectangle;
import model.entities.Shape;

import java.util.ArrayList;
import java.util.List;

public class App {
    public void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(3.0, 2.0));
        shapes.add(new Circle(2.0));

        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(3.0, 2.0));

        IO.print("Soma: ");
        IO.print(totArea(rectangles));

    }

    public static double totArea(List<? extends Shape> myList) {
        double sum = 0.0;
        for (Shape shape : myList) {
            sum += shape.calculateArea();
        }
        return sum;
    }
}
