package day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Boj7579 {

    static int n; // n개
    static int m; // 확보해야하는 메모리
    static int[] memory; // 확보 가능 메모리 배열
    static int[] cost; // 비용 배열
    static int[] dp; // k 만큼의 비용이 들었을 때, 확보 가능한 메모리

    static final int MAX_MEMORY = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        memory = new int[n + 1];
        cost = new int[n + 1];
        dp = new int[MAX_MEMORY + 1];
        Arrays.fill(dp, -1);

        st = new StringTokenizer(br.readLine()); // memory 초기화
        for (int i = 1; i <= n; i++) {
            memory[i] = parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()); // cost 초기화
        for (int i = 1; i <= n; i++) {
            cost[i] = parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            int c = cost[i];

            // j는 비용 dp[j] = dp[300] = 300 비용으로 얻을 수 있는 최대 메모리
            for (int j = MAX_MEMORY; j >= c; j--) {
                // 처음이 아닐 때
                if (dp[j - c] != -1) {

                    // j-cost만큼의 비용에서 얻을 수 있는 메모리와 현재 메모리를 더한 것이 이전보다 클 때 업데이트
                    if (dp[j - c] + memory[i] > dp[j])
                        dp[j] = dp[j - c] + memory[i];
                }
            }

            // 만약 현재 메모리가 비용에서 얻을 수 있는 메모리보다 크다면(cost = cost[i]) 업데이트
            if (dp[c] < memory[i]) dp[c] = memory[i];
        }

        for (int c = 0; c <= MAX_MEMORY; c++) {
            if (dp[c] >= m) {
                System.out.println(c);
                break;
            }
        }
    }
}
