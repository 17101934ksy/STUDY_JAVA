package dp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = calculateArrayLength();
        System.out.print(result);
    }

    static int calculateArrayLength() {

        int[] LisDp = new int[N + 1];
        int[] LdsDp = new int[N + 1];

        // 순행
        calculateLIS(LisDp);

        // 역행
        calculateLDS(LdsDp);

        // 결과
        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(LisDp[i] + LdsDp[i] - 1, result);
        }

        return result;

    }

    static void calculateLIS(int[] LisDp) {

        for (int i = 1; i <= N; i++) {
            LisDp[i] = 1;

            for (int j = 1; j < i; j++) {

                if (arr[j] < arr[i] && LisDp[i] <= LisDp[j]) {
                    LisDp[i] = LisDp[j] + 1;
                }

            }
        }

    }

    static void calculateLDS(int[] LdsDp) {

        for (int i = N; i >= 1; i--) {
            LdsDp[i] = 1;

            for (int j = N; j > i; j--) {

                if (arr[j] < arr[i] && LdsDp[i] <= LdsDp[j]) {
                    LdsDp[i] = LdsDp[j] + 1;
                }

            }
        }

    }
}