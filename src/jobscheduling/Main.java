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

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        jobScheduling = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            jobScheduling[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            jobScheduling[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(jobScheduling, Comparator.comparingInt(o1 -> o1[0]));

        si = jobScheduling[0][0];
        fi = jobScheduling[0][1];
        jobCnt = 1;

        for (int i = 1; i < n; i++) {

            if ((jobScheduling[i][0] >= si) && (jobScheduling[i][1] <= fi)) {
                si = jobScheduling[i][0];
                fi = jobScheduling[i][1];

            } else if (jobScheduling[i][0] >= fi) {
                si = jobScheduling[i][0];
                fi = jobScheduling[i][1];
                jobCnt++;
            }
        }

        System.out.printf(String.valueOf(jobCnt));

    }

}
