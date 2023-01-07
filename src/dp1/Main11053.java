package dp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main11053 {

    static int N;
    static int[] arr;
    static int[] lengths;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        arr = new int[N + 1];
        lengths = new int[N + 1];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = getMaxPartitionArrayLength();
        System.out.print(result);
    }

    static int getMaxPartitionArrayLength() {

        int result = 1;

        for (int i = 1; i <= N; i++) {

            lengths[i] = 1; // i번째에 도달하면 처음에는 길이가 1로 측정

            // i번보다 작은 인덱스에 있는 arr 배열의 숫자를 비교하여 점진적으로 증가
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i] && lengths[i] <= lengths[j]) {
                    lengths[i] = lengths[j] + 1;
                }
            }

            result = Math.max(result, lengths[i]);
        }

        return result;
    }

}
