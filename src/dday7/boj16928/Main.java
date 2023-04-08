package dday7.boj16928;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = getInt(st);
        int m = getInt(st);
        SnakeAndLadder snakeAndLadder = new SnakeAndLadder();

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            snakeAndLadder.setInit(getInt(st), getInt(st));
        }

        snakeAndLadder.findMinDice();
        System.out.println(snakeAndLadder.getMinDice());
    }

    static int getInt(StringTokenizer st) {
        return parseInt(st.nextToken());
    }
}


class SnakeAndLadder {

    static final int DESTINATION = 100;

    Location[] locations = new Location[DESTINATION + 1];
    boolean stop;
    class Location {
        int x; // 위치
        int y; // 이동할 위치
        int step; // 최소 이동 스텝
        boolean visited;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    SnakeAndLadder() {
        for(int i = 0; i < locations.length; i++) locations[i] = new Location(i, -1);
    }

    void setInit(int x, int y) {
        this.locations[x].y = y;
    }

    void findMinDice() {
        Queue<Location> queue = new ArrayDeque<>();
        locations[1].visited = true;
        queue.add(locations[1]);
        bfs(queue);
    }

    void bfs(Queue<Location> queue) {
        Location newLocation;

        while(!queue.isEmpty() && !stop) {
            Location location = queue.poll();


            if (location.x == DESTINATION) break;
            if (location.y == -1) {

                for (int dx = 1; dx <= 6; dx++) {
                    if (validRange(location.x + dx)) {
                        newLocation = locations[location.x + dx];

                        if (!newLocation.visited) {
                            newLocation.step = location.step + 1;
                        }

                        newLocation.visited = true;
                        queue.add(newLocation);

                        if (newLocation.x == DESTINATION) {
                            stop = true;
                            break;
                        }
                    }
                }
            }

            else {
                newLocation = locations[location.y];
                if (!newLocation.visited) {
                    newLocation.step = location.step;
                }
                newLocation.visited = true;
                queue.add(newLocation);
            }
        }
    }

    int getMinDice() {
        return locations[DESTINATION].step;
    }

    boolean validRange(int x) {
        return x <= 100 && !locations[x].visited;
    }
}
