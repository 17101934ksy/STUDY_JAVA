package dpcoin;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        // input: 잔돈을 계산해야 하는 동전 문자열 ', '로 문자열 분리
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(", ");

        // target: 잔돈
        int target = Integer.parseInt(bufferedReader.readLine());

        // preMinPartial: 최종 target을 완성하기 위한 부분 최소 동전 개수
        int preMinPartial;

        // 동전 배열과 dp 초기화
        int[] coinArr = new int[input.length];
        int[] dp = new int[target + 1];

        // dp값 최대값이 100000보다 작다고 되어 있으므로, 10만으로 초기화, dp[0]은 존재하지 않으므로 0
        Arrays.fill(dp, 100000);
        dp[0] = 0;

        // 해당 문자열 배열을 인트형 배열로 복사, 입력받은 동전으로 target을 상향식으로 찾기 위해 오름차순 정렬
        for (int i=0; i<input.length; i++) {
            coinArr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(coinArr);

        // 최종 target을 달성하기 위한 부분별 target 설정
        for (int partial=1; partial<=target; partial++) {

            for (int coin : coinArr) {

                // partial이 coin보다 작으면 오름차순 정렬이므로 이후 모든 코인은 partial보다 큼. 따라서 반복분 break
                if (partial < coin ) { break; }

                // 이전 partial의 target 저장 후 비교
                preMinPartial = dp[partial];
                dp[partial] = Math.min(dp[partial], dp[partial-coin]);

                // 이전 값과 다르면, 선택한 동전을 포함한 partial로 재설정해야 하므로, 1 더하기
                if (preMinPartial != dp[partial]) { dp[partial]++; }
            }
        }
        System.out.printf(String.valueOf(dp[target]));
    }
}
