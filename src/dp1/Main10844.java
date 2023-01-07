package dp1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main10844 {

    static final long MOD = 1000000000;
    static int N;
    static long[][] stair;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        stair = new long[N + 1][10]; // (n 자리수), (0 ~ 9)

        long result = doStairDp();
        System.out.print(result % MOD);
    }

    static long doStairDp() {

        for (int i = 1; i<10; i++) {
            stair[1][i] = 1; // 첫번째 자리수가 i 일때는 모두 1
        }

        for (int i = 2; i <= N; i++) {

            for (int j = 0; j < 10; j++) {

                if (j == 0) {
                    stair[i][0] = stair[i - 1][1] % MOD;
                }

                else if (j == 9) {
                    stair[i][9] = stair[i - 1][8] % MOD;
                }

                else {
                    stair[i][j] = stair[i - 1][j - 1] + stair[i - 1][j + 1] % MOD;
                }
            }
        }

        long result = 0L;
        for (int i = 0; i < 10; i++) {
            result += stair[N][i];
        }

        return result;
    }
}