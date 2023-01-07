package dp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main2516 {

    static int N;
    static int[] wine;
    static long[] wineDp;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        wine = new int[N + 1];
        wineDp = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(bf.readLine());
        }

        long result = drinkWine();
        System.out.print(result);
    }

    static long drinkWine() {

        if (N == 1) {
            return wine[1];
        }

        else if (N == 2) {
            return wine[1] + wine[2];
        }

        wineDp[1] = wine[1];
        wineDp[2] = wine[1] + wine[2];
        wineDp[3] = Math.max(wineDp[2], Math.max(wine[2] + wine[3], wine[1] + wine[3]));

        for (int i = 4; i <= N; i++) {
            wineDp[i] = Math.max(wineDp[i - 3] + wine[i - 1] + wine[i], wineDp[i - 2] + wine[i]);
            wineDp[i] = Math.max(wineDp[i - 1], wineDp[i]);
        }

        return wineDp[N];
    }
}