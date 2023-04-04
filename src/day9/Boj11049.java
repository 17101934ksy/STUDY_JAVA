package day9;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Boj11049 {

    static int n;
    static long[][] dp;
    static Matrix[] matrixs;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = parseInt(bf.readLine());
        dp = new long[n + 1][n + 1];
        matrixs = new Matrix[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bf.readLine());
            matrixs[i] = new Matrix(parseInt(st.nextToken()), parseInt(st.nextToken()));
        }

        // k는 1 ~ n까지 행렬의 곱 a b c d e f
        for (int k = 1; k <= n; k++) {

            // from은 시작점 1, 2, 3, 4, k = 2이라면
            for (int from = 1; from + k <= n; from++) {

                int to = from + k;
                dp[from][to] = Long.MAX_VALUE;

                // 3부터 5까지 행렬의 곱 + 5부터 7까지 행렬의 곱
                for (int d = from; d < to; d++) {

                    // to do
                    dp[from][to] = Math.min(dp[from][to],
                            dp[from][d] + dp[d + 1][to] + matrixs[from].getRow() * matrixs[d].getCol() * matrixs[to].getCol());
                }
            }
        }

        System.out.println(dp[1][n]);
    }

    static class Matrix {
        int row;
        int col;

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public Matrix(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}