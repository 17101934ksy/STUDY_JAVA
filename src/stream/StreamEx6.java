package stream;

import java.util.Arrays;
import java.util.List;

public class StreamEx6 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("a", "b", "c", "d", "a", "a", "b", "ab");

        names.stream()
                .distinct()
                .forEach(n -> System.out.println(n));

        System.out.println();

        names.stream()
                .filter(n -> n.startsWith("a"))
                .forEach(n -> System.out.println(n));

        System.out.println();

        names.stream()
                .distinct()
                .filter(n -> n.startsWith("a"))
                .forEach(n -> System.out.println(n));
    }
}
