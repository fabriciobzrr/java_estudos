import java.util.Arrays;
import java.util.stream.Stream;

void main() {
    Stream<Long> st1 = Stream.iterate(new Long[] {0L, 1L}, item -> new Long[]{item[1], item[0] + item[1]}).map(item -> item[0]);
    Stream<Long> st2 = Stream.iterate(new Long[] {0L, 1L}, item -> new Long[]{item[1], item[0] + item[1]}).map(item -> item[0]);

    List<Long> lista1 = st1.limit(10).collect(Collectors.toList());
    List<Long> lista2 = st2.limit(20).collect(Collectors.toList());
    IO.println(lista1);
    IO.println(lista2);
}
