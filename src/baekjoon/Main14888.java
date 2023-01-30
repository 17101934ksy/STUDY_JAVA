package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main14888 {

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int N;
    static int[] arr;
    static int[] operator = new int[4];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);
        System.out.println(MAX);
        System.out.print(MIN);

    }

    private static void dfs(int num, int idx) {

        if (idx == N) {

            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return ;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0: dfs(num + arr[idx], idx + 1); break;
                    case 1: dfs(num - arr[idx], idx + 1); break;
                    case 2: dfs(num * arr[idx], idx + 1); break;
                    case 3: dfs(num / arr[idx], idx + 1); break;
                }
                operator[i]++;
            }
        }
    }
}
