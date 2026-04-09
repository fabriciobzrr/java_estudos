package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    public static void main (String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Stream<Integer> stream1 = list.stream();
        IO.println(Arrays.toString(stream1.toArray()));

        Stream<String> stream2 = Stream.of("Fabricio", "Fred", "Billy", "Faber");
        IO.println(Arrays.toString(stream2.toArray()));

        Stream<Integer> stream3 = Stream.iterate(0, n -> n + 2);
        IO.println(Arrays.toString(stream3.limit(10).toArray()));

        Stream<Long> stream4 = Stream.iterate(new Long[] {0L, 1L}, x -> new Long[]{x[1], x[0]+x[1]}).map(x -> x[0]);
        IO.println(Arrays.toString(stream4.limit(20).toArray()));

        Stream<Integer> stream5 = list.stream().map(x -> x * 5);
        IO.println(Arrays.toString(stream5.toArray()));
        List<Integer> st5 = list.stream().map(x -> x * 5).collect(Collectors.toList());
        IO.println(st5);

        int sum = list.stream().reduce(0, (a, b) -> a + b);
        IO.println("Soma: " + sum);

        //
        List<Integer> nova = list.stream()
                .filter(x -> x % 2 != 0)
                .map(x -> x * 5)
                .collect(Collectors.toList());

        IO.println(nova);

        List<Integer> lista = new ArrayList<>();
        int x = 0, y = 1;
        for (int i = 0; i < 20; i++) {
            lista.add(x);
            int tot = x + y;
            x = y;
            y = tot;
        }

        IO.println(lista);
        IO.println("============================");

        List<String> myList = Arrays.asList("Fabricio", "Fred", "Billy", "Faber");
        myList.stream().forEach(System.out::println);
        myList.stream().forEach(System.out::println);


    }
}
