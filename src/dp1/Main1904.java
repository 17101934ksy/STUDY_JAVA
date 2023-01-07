package dp1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main1904 {

    private static final int MOD = 15746;
    static Integer memo[] = new Integer[1000001];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        System.out.print(dp(N));
    }

    static int dp(int N) {

        if (N == 0) {
            return 0;
        }

        else if (N == 1) {
            return 1;
        }

        else if (N == 2) {
            return 2;
        }

        if (memo[N] == null) {
            memo[N] = (dp(N-1) + dp(N - 2)) % MOD;
        }

        return memo[N];

    }
}
