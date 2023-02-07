package stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamEx10 {

    public static void main(String[] args) {
        int[] intArr = {1, 2, 3, 4, 5, 6};

        System.out.println("intArr = " + intArr);

        System.out.println("peek 마지막");
        Arrays.stream(intArr)
                .filter( f -> f >= 2)
                .peek(p -> System.out.println(p));
        System.out.println();

        System.out.println("for each 마지막");
        Arrays.stream(intArr)
                .filter( f -> f >= 2)
                .forEach(p -> System.out.println(p));
        System.out.println();

        System.out.println("peek 동작");
        int sum = Arrays.stream(intArr)
                .filter(f -> f >= 2)
                .peek(p -> System.out.println(p))
                .sum();
        System.out.println("sum = " + sum);
        System.out.println();

    }
}
