package application;

import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main (String[] args) {
        List<Double> listD = Arrays.asList(23.34, 325.22, 75.50, 88.90);
        printerL(listD);
        IO.println();
        List<String> listStr = Arrays.asList("Fred", "Fabricio", "Billy", "Faber");
        printerL(listStr);
    }
    public static void printerL(List<?> ownList) {
        for (Object item : ownList) {
            IO.print(item + "\n");
        }
    }
}
