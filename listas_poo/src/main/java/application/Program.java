package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();

        lista.add("Fabricio");
        lista.add("Faber");
        lista.add("Fred");
        lista.add("Billy");
        lista.add("Brock");
        lista.add("Malenia");
        lista.add(1, "Fabra1");
        System.out.println(lista);
        System.out.println(lista.size());

        for (String item : lista) {
            System.out.println(item);
        }

        System.out.println("---------------");
        System.out.println(lista.indexOf("Malenia"));
        System.out.println("---------------");
        List<String> result = lista.stream().filter(el -> el.charAt(0) == 'M').collect(Collectors.toList());

        for (String item : result) {
            System.out.println(item);
        }
        System.out.println("---------------");

        String name = lista.stream().filter(el -> el.charAt(0) == 'F').findFirst().orElse(null);
        System.out.println(name);

    }
}
