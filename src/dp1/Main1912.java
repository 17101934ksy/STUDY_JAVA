package dp1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main1912 {

    static long[] memo;
    static long max;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());

        memo = new long[n];
        memo[0] = Integer.parseInt(st.nextToken());
        max = memo[0];

        for (int i = 1; i < n; i++) {
            doDp(i, Integer.parseInt(st.nextToken()));
        }

        System.out.print(max);
    }

    static void doDp(int idx, int n) {
        memo[idx] = Math.max(n, memo[idx - 1] + n);
        max = Math.max(max, memo[idx]);
    }
}
