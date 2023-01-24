package dp1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;


public class Main2565 {

    static int n;
    static int[] dp;
    static int[][] link;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        dp = new int[n + 1];
        link = new int[n + 1][2];

        StringTokenizer st;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(bf.readLine());
            link[i][0] = Integer.parseInt(st.nextToken());
            link[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(link, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int result = calculateLIS();
        System.out.print(result);




    }

    static int calculateLIS() {

        int result = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j < i; j++) {

                if (link[i][1] > link[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            result = Math.max(result, dp[i]);
        }

        return n - result;
    }
}