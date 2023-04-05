package day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Boj1520 {

    private static int m,n;

    private static int[][] map;
    private static int[][] dp;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        m = parseInt(st.nextToken());
        n = parseInt(st.nextToken());

        map = new int[m+1][n+1];
        dp = new int[m+1][n+1];

        for (int i=1; i<=m; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j=1; j<=n; j++) {
                map[i][j] = parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(1,1));

    }

    private static int dfs(int x, int y) {

        if (x == m && y == n) {
            return 1;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        } else {

            dp[x][y] = 0;
            for (int i=0; i<dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || ny < 1 || nx > m || ny > n) {
                    continue;
                }

                if (map[x][y] > map[nx][ny]) {
                    dp[x][y] += dfs(nx, ny);
                }
            }

        }

        return dp[x][y];

    }
}