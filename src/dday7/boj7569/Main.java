package dday7.boj7569;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = getInt(st); // 열 - 5
        int n = getInt(st); // 행  - 3
        int h = getInt(st); // 높이 - 2

        Storage storage = new Storage(n, m, h); // n 행, m 열, h 높이

        // n * h 입력
        for (int i = 0; i < n * h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                storage.setInit(i % n, j, i / n, getInt(st));
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

    static final int[] D_X = {1, 0, -1, 0, 1, 0, -1, 0, 0, 0};
    static final int[] D_Y = {0, 1, 0, -1, 0, 1, 0, -1, 0, 0};
    static final int[] D_Z = {0, 0, 0, 0, 0, 0, 0, 0, 1, -1};


    Tomato[][][] tomatos;
    List<Tomato> alreadyFinishedTomatos = new ArrayList<>();

    int totalCnt; // 처리한 총 tomato 개수
    int maxDate; // 최대 날짜
    int tomatosLength; // 토마토 3차원 배열의 총 개수

    class Tomato {
        int x; // x 좌표
        int y; // y 좌표
        int z; // z 좌표
        int step; // bfs의 깊이
        boolean visited; // 방문 여부

        Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    Storage(int m, int n, int h) {
        tomatos = new Tomato[m][n][h]; // 토마토 배열 생성
        tomatosLength = tomatos.length * tomatos[0].length * tomatos[0][0].length;
    }

    void setInit(int x, int y, int z, int status) {
        if (status == -1) {
            totalCnt++; // 빈 토마토는 처리할 수 없으므로 카운트만 증가
            return;
        }

        tomatos[x][y][z] = new Tomato(x, y, z);
        if (status == 1) {
            totalCnt++; // 이미 익은 토마토는 처리하지 않아도 되므로 카운트 증가
            alreadyFinishedTomatos.add(tomatos[x][y][z]); // 큐에서 빼기 위해 리스트에 추가
        }
    }

    void findFinishedDate() {
        if (totalCnt == tomatosLength) {
            maxDate = 0; // 당일에 모두 처리되어서 처리해야 할 토마토가 없는 경우
            return;
        }

        Queue<Tomato> queue = new ArrayDeque<>();
        for (Tomato tomato : alreadyFinishedTomatos) {
            tomato.visited = true; // 방문 처리
            queue.add(tomato); // 큐에 넣기
        }

        bfs(queue);
    }

    void bfs(Queue<Tomato> queue) {
        int newX, newY, newZ; // 새로운 좌표 생성
        Tomato newTomato; // 새로운 토마토 선언
        while(!queue.isEmpty()) {

            Tomato tomato = queue.poll(); // 토마토 큐에서 빼기
            setMaxDate(tomato.step); // 최대 날짜 계산

            if (totalCnt == tomatosLength) return; // 토마토가 전부 처리된 경우

            for (int k = 0; k < D_X.length; k++) {
                newX = tomato.x + D_X[k];
                newY = tomato.y + D_Y[k];
                newZ = tomato.z + D_Z[k];

                if (validRange(newX, newY, newZ)) {
                    newTomato = tomatos[newX][newY][newZ]; // 토마토 배열에서 토마토 꺼내기
                    newTomato.visited = true; // 방문 처리
                    newTomato.step = tomato.step + 1; // 깊이 추가
                    setMaxDate(newTomato.step); // 날짜 계산
                    totalCnt++;
                    queue.add(newTomato);
                }
            }
        }

        if (totalCnt != tomatosLength) {
            maxDate = -1;
        }
    }

    int getFinishedDate() {
        return maxDate;
    }

    boolean validRange(int x, int y, int z) {
        return x >= 0 && y >= 0 && z >= 0 &&
                x < tomatos.length && y < tomatos[0].length && z < tomatos[0][0].length &&
                tomatos[x][y][z] != null &&
                !tomatos[x][y][z].visited; // 방문 안해야 함
    }

    void setMaxDate(int step) {
        maxDate = Math.max(maxDate, step);
    }
}