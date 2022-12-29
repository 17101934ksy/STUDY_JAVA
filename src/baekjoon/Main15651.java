package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main15651 {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        dfs(0);
        System.out.println(sb);

    }

    static void dfs(int depth) {

        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append('\n');
            return ;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = i;

            dfs(depth + 1);
        }
    }
}
