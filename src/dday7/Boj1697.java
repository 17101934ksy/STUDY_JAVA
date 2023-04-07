package dday7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.ArrayDeque;

import static java.lang.Integer.parseInt;

public class Boj1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int k = parseInt(st.nextToken());

        HideAndSeek hideAndSeek = new HideAndSeek(n, k);
        hideAndSeek.findTime();
        hideAndSeek.printTime();
    }
}

class HideAndSeek {

    static final int MAX_DISTANCE = 100001; // 최대 거리 (0, 10만 일 경우)
    Location[] locations = new Location[MAX_DISTANCE];

    int n; // 수빈 위치
    int k; // 동생 위치

    class Location {
        int x; // 위치 좌표
        int t; // 걸린 시간
        boolean visited; // 방문 여부

        Location(int x) {
            this.x = x;
        }
    }

    HideAndSeek(int n, int k) { // 생성자로 Location[] 배열에 location 등록
        this.n = n;
        this.k = k;
        for (int i = 0; i < MAX_DISTANCE; i++) locations[i] = new Location(i);
    }

    void findTime() {
        Queue<Location> queue = new ArrayDeque<>();
        locations[n].visited = true;
        queue.add(locations[n]); // 먼저 수빈 위치의 인스턴스를 큐에 등록
        bfs(queue); // bfs 시작
    }

    void bfs(Queue<Location> queue) {
        int d;
        while(!queue.isEmpty()) {
            Location location = queue.poll(); // 큐에 있는 location 인스턴스 추출

            if (location.x == k) break; // 만약 시간이 같다면 break;

            d = location.x;
            int[] dx = {d + 1, d - 1, d * 2};

            // 만약 현재 위치에서 dx만큼 변한 것이 0보다 크고, 최대 거리를 넘지 않고, 방문 X라면
            for (int z : dx) {
                if (z >= 0 && z < MAX_DISTANCE && !locations[z].visited) {
                    locations[z].visited = true;
                    locations[z].t = location.t + 1; // 다음에 탐색할 location의 시간을 1 추가
                    queue.add(locations[z]);
                }
            }
        }
    }

    void printTime() {
        System.out.println(locations[k].t);
    }
}