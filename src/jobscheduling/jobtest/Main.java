package jobscheduling.jobtest;

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
    static int maxJob;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        jobScheduling = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            jobScheduling[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            jobScheduling[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(jobScheduling, Comparator.comparingInt(o1 -> o1[0]));

        for (int j = 0; j < n; j++) {
            si = jobScheduling[j][0];
            fi = jobScheduling[j][1];
            jobCnt = 1;

            if (maxJob > (n - j)) {
                break;
            }

            for (int i = j+1; i < n; i++) {
                if (jobScheduling[i][0] > fi) {
                    si = jobScheduling[i][0];
                    fi = jobScheduling[i][1];
                    jobCnt++;
                }
            }

            if (jobCnt > maxJob) {
                maxJob = jobCnt;
            }
        }

        System.out.printf(String.valueOf(maxJob));

    }

}
