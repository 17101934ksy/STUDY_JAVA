package dday6.boj2206;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Collections;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = getInt(st);
        int m = getInt(st);

        BrickMap map = new BrickMap(n, m);

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map.addRoad(i, j , Character.getNumericValue(str.charAt(j)));
            }
        }

        System.out.println(map.findRoadCnt());
    }

    static int getInt(StringTokenizer st) {
        return parseInt(st.nextToken());
    }
}

class BrickMap {

    static final int[] D_X = {1, 0, -1, 0};
    static final int[] D_Y = {0, 1, 0, -1};

    int zeroNum;
    Road[][] roads;
    List<Road> possibleBrickRoad = new ArrayList<>();

    class Road {
        int x;
        int y;
        int step = 1;
        int num;
        boolean visited;

        Road(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

    }

    BrickMap(int n, int m) {
        roads = new Road[n][m];
    }

    void addRoad(int x, int y, int num) {
        roads[x][y] = new Road(x, y, num);
        if (num == 0) zeroNum++;
        else if (num == 1) possibleBrickRoad.add(roads[x][y]);
    }


    int findRoadCnt() {

        boolean init = false;

        if (zeroNum < roads.length + roads[0].length - 2) {
            return -1;
        }

        Queue<Road> queue = new ArrayDeque<>();
        List<Integer> cnts = new ArrayList<>();

        roads[0][0].visited = true;
        queue.add(roads[0][0]);
        cnts.add(bfs(queue));

        if (!possibleBrickRoad.isEmpty()) {
            for (Road r : possibleBrickRoad) {

                if (!init) setInit();
                if (isPossibleShortRoad(r)) {
                    queue = new ArrayDeque<>();

                    r.num = 0;
                    roads[0][0].visited = true;

                    queue.add(roads[0][0]);
                    cnts.add(bfs(queue));
                    r.num = 1;
                    init = false;
                } else {
                    init = true;
                }
            }
        }

        Collections.sort(cnts);
        for (Integer c : cnts) {
            if (c != -1)
                return c;
        }

        return -1;
    }

    void setInit() {
        for (int i = 0; i < roads.length; i++)
            for (int j = 0; j < roads[0].length; j++)
                roads[i][j].visited = false;
    }

    int bfs(Queue<Road> queue) {
        while(!queue.isEmpty()) {
            Road road = queue.poll();

            if (checkBreak(road.x, road.y)) {
                return road.step;
            }

            for (int k = 0; k < D_X.length; k++) {
                int newX = road.x + D_X[k];
                int newY = road.y + D_Y[k];

                if (validRange(newX, newY)) {

                    roads[newX][newY].step = road.step + 1;
                    roads[newX][newY].visited = true;
                    queue.add(roads[newX][newY]);

                    if (checkBreak(newX, newY)) {
                        return roads[newX][newY].step;
                    }

                }
            }
        }

        return -1;

    }

    boolean validRange(int x, int y) {
        return x >= 0 && y >= 0 &&
                x < roads.length && y < roads[0].length &&
                !roads[x][y].visited && roads[x][y].num != 1;
    }

    boolean checkBreak(int x, int y) {
        return x == roads.length - 1 && y == roads[0].length - 1;
    }

    boolean isPossibleShortRoad(Road road) {
        int cnt = 0;
        for (int k = 0; k < D_X.length; k++) {
            int newX = road.x + D_X[k];
            int newY = road.y + D_Y[k];

            if (validRange(newX, newY)) cnt++;
        }

        return cnt >= 2;
    }
}