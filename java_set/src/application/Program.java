package application;

import java.util.*;

public class Program {
    public static void main (String[] args) {
        Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 6, 8, 10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(4, 8, 10, 12, 14, 16));

        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        IO.println(c);

        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        IO.println(d);

        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        IO.println(e);

        Set<String> conj = new LinkedHashSet<>();
        conj.add("Mouse");
        conj.add("Teclado");
        conj.add("Headset");
        conj.add("Mousepad");
        conj.add("Monitor");

        IO.println(conj);
        IO.println(conj.contains("Audio Board"));
        conj.remove("Monitor");
        conj.removeIf(item -> item.charAt(0) == 'M');
        IO.println(conj);


    }
}
