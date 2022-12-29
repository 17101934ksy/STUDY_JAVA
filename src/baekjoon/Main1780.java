package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;


public class Main1780 {

    static int minusOneCnt;
    static int zeroCnt;
    static int oneCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int j = 0;
            while(st.hasMoreTokens()) {
                matrix[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        divideConquer(matrix, 0, 0, N);

        System.out.println(minusOneCnt);
        System.out.println(zeroCnt);
        System.out.print(oneCnt);

    }
    
    static void divideConquer (int[][] matrix, int row, int col, int m) {
        int num = matrix[row][col];
        boolean flag = true;

        loop:
        for (int i = row; i < row + m; i++) {
            for (int j = col; j < col + m; j++) {
                if (num != matrix[i][j]) {
                    flag = false;
                    break loop;
                }
            }
        }

        if (checkMatrix(num, flag)) return;

        doNewDivideConquer(matrix, row, col, m);
    }

    private static boolean checkMatrix(int num, boolean flag) {
        if (flag) {
            switch (num) {
                case -1:
                    minusOneCnt++;
                    break;
                case 0:
                    zeroCnt++;
                    break;
                case 1:
                    oneCnt++;
                    break;
            }
            return true;
        }
        return false;
    }

    private static void doNewDivideConquer(int[][] matrix, int row, int col, int m) {
        int next = m / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divideConquer(matrix, row + next * i, col + next * j, next);
            }
        }
    }

}