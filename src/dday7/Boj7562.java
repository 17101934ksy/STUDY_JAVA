package dday7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Boj7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = getInt(br);
        for (int i = 0; i < testCase; i++) {
            int line = getInt(br); // 라인 길이

            st = new StringTokenizer(br.readLine()); // 초기 위치
            Knight knight = new Knight(line, getInt(st), getInt(st)); // 생성자 생성

            st = new StringTokenizer(br.readLine()); // 찾아야 하는 위치

            knight.setFindLocation(getInt(st), getInt(st)); // 찾을 위치 등록
            knight.findLocation(); // 위치 찾기

            sb.append(knight.getMoveStep()).append('\n');
        }

        System.out.println(sb);

    }

    static int getInt(BufferedReader br) throws IOException {
        return parseInt(br.readLine());
    }

    static int getInt(StringTokenizer st) {
        return parseInt(st.nextToken());
    }
}

class Knight {

    static final int[] D_X = {2, 2, -2, -2, 1, 1, -1, -1}; // 2 by 1;
    static final int[] D_Y = {1, -1, 1, -1, 2, -2, 2, -2};

    Move[][] moves;
    int x; // kight 처음 x 위치
    int y; // kight 처음 y 위치
    int findX; // 찾아야 할 x 위치
    int findY; // 찾아야 할 y 위치

    class Move {
        int x;
        int y;
        int step;
        boolean visited;

        Move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Knight(int n, int x, int y) {
        this.x = x;
        this.y = y;
        moves = new Move[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) moves[i][j] = new Move(i, j);
    }

    void setFindLocation(int findX, int findY) {
        this.findX = findX;
        this.findY = findY;
    }

    void findLocation() {
        Queue<Move> queue = new ArrayDeque<>();
        moves[x][y].visited = true; // 처음 방문할 위치 visited 처리
        queue.add(moves[x][y]); // queue에 넣기
        bfs(queue); // bfs 실행
    }

    void bfs(Queue<Move> queue) {
        while(!queue.isEmpty()) {
            Move move = queue.poll();
            if (move.x == findX && move.y == findY) break;

            for (int k = 0; k < D_X.length; k++) {
                int newX = move.x + D_X[k];
                int newY = move.y + D_Y[k];

                if (validRange(newX, newY)) {
                    moves[newX][newY].visited = true;
                    moves[newX][newY].step = move.step + 1;
                    queue.add(moves[newX][newY]);
                }
            }
        }
    }

    int getMoveStep() {
        return moves[findX][findY].step;
    }

    boolean validRange(int x, int y) {
        return x >= 0 && y >= 0 && // 0보다 크거나 같고
                x < moves.length && y < moves.length && // 한 변의 길이보다는 작고
                !moves[x][y].visited; // 방문하지 않은 경우

    }

}