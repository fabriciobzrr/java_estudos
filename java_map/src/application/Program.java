package application;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Program {
    public static void main (String[] args) {
        // TreeMap - ordenado
        // HashMap - velocidade
        // LinkedHashMap - ordem de inserção
        Map<String, String> cookies = new TreeMap<>();

        cookies.put("username", "Fabra1");
        cookies.put("name", "Fabricio");
        cookies.put("lastname", "Bezerra");
        cookies.put("email", "fab@m.c");
        cookies.put("phone", "8795566231");

        cookies.put("phone", "8349849043");

        IO.println("Contém 'name': " + cookies.containsKey("name"));
        IO.println("Contém 'midname': " + cookies.containsKey("midname"));

        IO.println("Ultimo nome: " + cookies.get("lastname"));

        IO.println("Cidade: " + cookies.get("cidade"));


        IO.println("==========================");
        for (String key : cookies.keySet()) {
            IO.println(key + ": " + cookies.get(key));
        }
    }
}
