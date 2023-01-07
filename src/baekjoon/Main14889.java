package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main14889 {

    static int N;
    static int[][] map;
    static boolean[] visit;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        map = new int[N][N];
        visit = new boolean[N];
        /*
         * visit으로 체크 (인원의 인덱스 역할)
         */

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        combination(0, 0);
        System.out.print(min);
    }

    private static void combination(int idx, int depth) {

        if (depth == N / 2) {
            /*
            방문한 팀과 방문하지 않은 팀을 나누어 각 팀의 점수를 구한 뒤
            최솟값을 적기
             */
            diffScore();
            return ;
        }

        for (int i = idx; i < N; i++) {

            if (!visit[i]) {
                visit[i] = true;
                combination(i, depth + 1);
                visit[i] = false; // 재귀가 끝나면 비방문으로 변경하기
            }

        }
    }

    private static void diffScore() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {

                if (visit[i] && visit[j]) {
                    teamStart += map[i][j];
                    teamStart += map[j][i];
                }

                else if (!visit[i] && !visit[j]) {
                    teamLink += map[i][j];
                    teamLink += map[j][i];
                }
            }
        }

        int val = Math.abs(teamStart - teamLink);
        /*
        두 팀의 점수차가 0이라면, 가장 낮은 최솟값이기 때문에
        더 이상의 탐색이 필요없이 0을 출력하고 종료한다
         */

        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        min = Math.min(val, min);

    }
}
