package dday3.boj_14002;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = parseInt(br.readLine());
        Sequence sq = new Sequence(n);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) sq.add(i, getInt(st));

        sq.find();
        br.close();
    }

    private static int getInt(StringTokenizer st) {
        return parseInt(st.nextToken());
    }
}

class Sequence {
    int[] dp;
    int[] trace;
    int[] sq;

    Sequence(int n) {
        dp = new int[n + 1];
        sq = new int[n + 1];
        trace = new int[n + 1];
    }

    void add(int i, int n) {
        sq[i] = n;
    }

    void find() throws IOException {

        dp[1] = 1;
        int ans = 1;
        for (int i = 2; i <= dp.length - 1; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (sq[i] > sq[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }

        int value = ans;
        Stack<Integer> stack = new Stack<>();

        for (int i = dp.length - 1; i >= 1; i--) {
            if (value == dp[i]) {
                stack.push(sq[i]);
                value--;
            }
        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(ans + "\n");
        while( !stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }
        bw.flush();
        bw.close();
    }
}

//x 10 20 5 8 7 9 15 17 20
// n + 1 = length 8