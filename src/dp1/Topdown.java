package dp1;

import java.util.Scanner;

public class Topdown {

    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n+1];

        System.out.println(fibo(n));
    }

    static int fibo(int x) {
        if((x == 1) || (x == 2)) return 1;
        if(dp[x] != 0) return dp[x];
        dp[x] = fibo(x-1) + fibo(x-2);
        return dp[x];
    }
}
