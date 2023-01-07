package dp1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main9461 {

    static Long[] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine());

            memo = new Long[N];
            System.out.println(doDp(N));
        }

    }

    static long doDp(int N) {

        /*
        점화식 A(n) = A(n-1) + A(n-5) (단, 7 <= n)
         */

        if (N < 6) {

            if (N == 1 || N == 2 || N == 3) {
                return 1;
            }

            else if (N == 4 || N == 5) {
                return 2;
            }
        }

        memo[0] = 1L;
        memo[1] = 1L;
        memo[2] = 1L;
        memo[3] = 2L;
        memo[4] = 2L;

        for (int i = 5; i < N; i++) {
            memo[i] = memo[i - 1] + memo[i - 5];
        }

        return memo[N-1];
    }
}
