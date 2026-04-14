package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program {
    public static void main (String[] args) {
        Stream<Integer> st1 = Stream.iterate(new Integer[] {0, 1}, x -> new Integer[] {x[1], x[0]+x[1]}).map(x -> x[0]);
        IO.println(Arrays.toString(st1.limit(20).toArray()));
    }
}
