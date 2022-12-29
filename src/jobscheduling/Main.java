package jobscheduling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int[][] jobScheduling;
    static int si;
    static int fi;
    static int jobCnt;

    public static void main(String[] args) throws IOException {

        // 버퍼로 입력 받기
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        jobScheduling = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            jobScheduling[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            jobScheduling[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        // 작업 시작 시간 순으로 정렬
        Arrays.sort(jobScheduling, Comparator.comparingInt(o1 -> o1[0]));

        si = jobScheduling[0][0];
        fi = jobScheduling[0][1];
        jobCnt = 1;

        for (int i = 1; i < n; i++) {

            // 시작 시간과 종료 시간 사이에 작업이 존재하면, 작업 시작 시간과 종료 시간을 주어진 인덱스에 해당하는 작업으로 업데이트
            if ((jobScheduling[i][0] >= si) && (jobScheduling[i][1] <= fi)) {
                si = jobScheduling[i][0];
                fi = jobScheduling[i][1];

            } else if (jobScheduling[i][0] >= fi) {

                // 작업 종료 시간보다 이후라면, 작업 업데이트 후, 작업 개수 증가
                si = jobScheduling[i][0];
                fi = jobScheduling[i][1];
                jobCnt++;
            }
        }

        // 작업 출력
        System.out.printf(String.valueOf(jobCnt));

    }

}
