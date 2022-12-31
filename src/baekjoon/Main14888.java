package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main14888 {

    static int N;
    static Long result;

    static long maxResult, minResult;
    static long[] arr;
    static int[] operator = new int[4];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < st.countTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < operator.length; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        result = arr[0];

        doOperator(result, 0);
        System.out.println(maxResult);
//        System.out.println(minResult);

    }

    public static void doOperator(Long result, int depth) {

        if (depth == N) {

            if (result > maxResult) {
                maxResult = result;
            } else if (result < minResult) {
                minResult = result;
            }
            return ;
        }

        for (int i = 0; i < operator.length; i++) {

            for (int j = 0; j < operator[i]; j++) {

                if (i == 0) {
                    result = result + arr[depth+1];
                } else if (i == 1) {
                    result = result - arr[depth+1];
                } else if (i == 2) {
                    result = result * arr[depth+1];
                } else {
                    result = result / arr[depth+1];
                }

                doOperator(result, depth + 1);
            }
        }
    }

}
