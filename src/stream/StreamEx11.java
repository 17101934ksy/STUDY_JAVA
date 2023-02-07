package stream;

import java.util.Arrays;

public class StreamEx11 {

    public static void main(String[] args) {
        int[] intArr = {2, 4, 5};

        boolean result = Arrays.stream(intArr)
                .allMatch(a -> a%2 == 0);

        System.out.println("result = " + result);

        boolean b = Arrays.stream(intArr)
                .anyMatch(a -> a % 3 == 0);
        System.out.println("b = " + b);

        boolean b1 = Arrays.stream(intArr)
                .noneMatch(a -> a % 3 == 0);
        System.out.println("b1 = " + b1);
    }
}
