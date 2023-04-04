package day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Boj11066 {

    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = parseInt(bf.readLine());

        int k;
        int[] sum;
        int[][] dp;

        for (int i = 0; i < t; i++) {
            k = parseInt(bf.readLine());
            sum = new int[k + 1];
            dp = new int[k + 1][k + 1];

            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= k; j++) {
                sum[j] = sum[j - 1] + parseInt(st.nextToken());
            }

            for (int n = 1; n <= k; n++) {
                for (int from = 1; from + n <= k; from++) {
                    int to = from + n;
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int d = from; d < to; d++) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][d] + dp[d + 1][to] + sum[to] - sum[from - 1]);
                    }
                }
            }
            System.out.println(dp[1][k]);
        }


    }


}