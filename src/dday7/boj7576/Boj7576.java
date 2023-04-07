package dday7.boj7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Boj7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = getInt(st);
        int n = getInt(st);

        Storage storage = new Storage(m, n); // 토마토 창고 객체 생성
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                storage.setInit(j, i, getInt(st));
            }
        }

        storage.findFinishedDate();
        System.out.println(storage.getFinishedDate());
    }

    static int getInt(StringTokenizer st) {
        return parseInt(st.nextToken());
    }
}

class Storage {

    class Tomato {
        int x;
        int y;
        int step;
        boolean visited;

        Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int[] D_X = {1, 0, -1, 0};
    static final int[] D_Y = {0, 1, 0, -1};
    Tomato[][] tomatos;
    int totalCnt;
    int maxDate;
    List<Tomato> alreadyFinishedTomatos = new ArrayList<>();

    Storage(int m, int n) {
        tomatos = new Tomato[m][n];
    }

    void setInit(int x, int y, int status) {
        if (status == -1) {
            totalCnt++; // 만약 -1 이라면 카운트만 늘리고 return;
            return;
        }

        tomatos[x][y] = new Tomato(x, y);
        if (status == 1) {
            totalCnt++; // 1이라면 ArrayList에 등록
            alreadyFinishedTomatos.add(tomatos[x][y]);
        }
    }

    void findFinishedDate() {

        if (totalCnt == tomatos.length * tomatos[0].length) {
            maxDate = 0; // 만약 처음부터 모두 완료된 상태라면 0 리턴
            return;
        }

        Queue<Tomato> queue = new ArrayDeque<>();
        for (Tomato tomato : alreadyFinishedTomatos) {
            tomato.visited = true; // 이미 익은 토마토 방문 처리
            queue.add(tomato); // 큐 등록
        }
        bfs(queue);
    }

    void bfs(Queue<Tomato> queue) {
        while(!queue.isEmpty()) {
            Tomato tomato = queue.poll();

            maxDate = Math.max(maxDate, tomato.step); // 가장 최고의 깊이 등록
            if (totalCnt == tomatos.length * tomatos[0].length) break;

            for (int k = 0; k < D_X.length; k++) {
                int newX = tomato.x + D_X[k];
                int newY = tomato.y + D_Y[k];

                if (validRange(newX, newY)) {
                    tomatos[newX][newY].visited = true;
                    tomatos[newX][newY].step = tomato.step + 1;
                    totalCnt++; // 방문한 토마토 카운트 증가
                    // queue에 newX, newY에 대해  한번 더 최대 date 등록
                    maxDate = Math.max(maxDate, tomatos[newX][newY].step);
                    queue.add(tomatos[newX][newY]);
                }
            }
        }

        if (totalCnt != tomatos.length * tomatos[0].length) maxDate = -1;
    }

    int getFinishedDate() {
        return maxDate;
    }

    boolean validRange(int x, int y) {
        return x >= 0 && y >= 0 && // 0 이상
                x < tomatos.length && y < tomatos[0].length && // 인덱스 유효 범위
                tomatos[x][y] != null && // null이 아니여야 함
                !tomatos[x][y].visited; // 아직 방문 X
    }
}

    