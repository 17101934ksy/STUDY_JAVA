package dp1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main2579 {

    static int n;
    static int[] arr;
    static int[] scores;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine()); // 입력받는 개수
        arr = new int[n]; // 입력받는 배열
        scores = new int[n]; // 점수 dp 스코어

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        long result = calculateDpScore();
        System.out.print(result);

    }

    static long calculateDpScore() {

        if (n == 1) {
            return arr[0];
        }

        else if (n == 2) {
            return arr[0] + arr[1];
        }

        scores[0] = arr[0];
        scores[1] = arr[0] + arr[1];
        scores[2] = Math.max(arr[0], arr[1]) + arr[2];

        for (int i = 3; i < n; i++) {
            scores[i] = Math.max(scores[i - 3] + arr[i - 1], scores[i - 2]) + arr[i];
        }

        return scores[n-1];
    }

}