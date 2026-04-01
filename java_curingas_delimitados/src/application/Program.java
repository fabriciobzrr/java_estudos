package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main (String[] args) {
        List<Integer> myInts = Arrays.asList(23,54,124,67, 438);
        List<Double> myDoubles = Arrays.asList(23.3, 44.1, 54.34, 489.43, 283.22);
        List<Object> myObjects = new ArrayList<>();

        makeCopy(myInts, myObjects);
        printer(myObjects);
        makeCopy(myDoubles, myObjects);
        printer(myObjects);



    }
    // List<? extends Number> -> uma lista que recebe qualquer subtipo (abaixo de) de Number,
    // ou seja, uma lista que recebe qualquer tipo que herda de Number
    // List<? super Number> -> uma lista que recebe qualquer supertipo (acima de) de Number,
    // ou seja, uma lista que recebe qualquer tipo que pode ser um ancestral de Number
    // No caso o próprio Number ou qualquer um dos seus ancestrais (Object)
    public static void makeCopy(List<? extends Number> origin, List<? super Number> destiny) {
        for (Number number : origin) {
            destiny.add(number);
        }
    }

    public static void printer(List<?> list) {
        for(Object item : list) {
            IO.print(item + " ");
        }
        IO.print("\n");
    }
}
