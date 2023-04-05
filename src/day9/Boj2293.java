package day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Boj2293 {

    static int n; // n개의 동전
    static int k; // n원의 가치를 만족시켜야함
    static int[] coin; // 동전 가치 배열 10만 이하 중복 가능
    static int[] dp;
    static final int MAX_VALUES = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        coin = new int[n + 1];
        dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coin[i] = parseInt(br.readLine());
        }

        dp[0] = 1;
        // i = 4 coin[4] = 50 일 때,
        for (int i = 0; i < n; i++) {

            // j = 1000, dp[1000] += dp[950]
            for (int j = 1; j <= k; j++) {
                if (j >= coin[i]) dp[j] += dp[j - coin[i]];
            }
        }
        // 동전은 1 ~ k 범위까지의 가격에 하나씩 대입되어 가격을 형성하고
        // dp로 이전에 형성된 가격 활용 dp[0] ~ dp[k]


        System.out.println(dp[k]);
    }
}
