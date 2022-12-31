package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main9664 {

    static int[] arr;
    static int N;
    static int count = 0;

    public static void nQueen(int depth) {

        if (depth == N) {
            count ++;
            return ;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (isPossibility(depth)) {
                nQueen(depth + 1);
            }
        }

    }

    public static boolean isPossibility(int col) {

        for (int i = 0; i < col; i++) {

            if (arr[col] == arr[i]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader  bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        arr = new int[N];
        nQueen(0);
        System.out.print(count);
    }
}
