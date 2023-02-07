package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx3 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");

        Stream<String> stream = list.stream();
        stream.forEach(StreamEx3::print);


        Stream<String> stringStream = list.parallelStream();
        stringStream.forEach(StreamEx3::print);
    }

    public static void print(String str) {
        System.out.println("str : " + Thread.currentThread().getName());
    }
}
