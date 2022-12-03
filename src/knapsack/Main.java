package knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;
    static int[][] item;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int w = Integer.parseInt(stringTokenizer.nextToken());

        dp = new int[n+1][w+1];
        item = new int[n+1][2];

        for (int i=1; i<=n; i++) {

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            item[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            item[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        //dp 태이블 순회
        for(int row=1; row<=n; row++) {

            for (int col=1; col<=w; col++) {

                if (item[row][1] - col >= 0) {
                    dp[row][col] = dp[row-1][col];
                }
                else {
                    dp[row][col] = Math.max(dp[row-1][col], dp[row-1][col - item[row][1]] + item[row][0]);
                }
            }
        }

        System.out.printf(String.valueOf(dp[n][w]));

    }
}
