package dp1;

import java.util.Scanner;

public class Simple {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n+1];
        System.out.println("fibo(n) = " + fibo(n));
    }

    static int fibo(int x) {
        if ((x == 1 ) || (x == 2)) return 1;
        return fibo(x-1) + fibo(x-2);
    }
}
