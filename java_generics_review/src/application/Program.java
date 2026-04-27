package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main (String[] args) {
        List<Object> obje = Arrays.asList(new Object(), new Object(), new Object());
        exeemplo(obje);

    }
//    public static void exemplo(List<?> lista) {
//        lista.add("texto");
//    }

    public static void exeemplo(List<?> lista) {
        Object obj = lista.get(0);
        System.out.println(obj);
    }
}
