package dday8;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Boj2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = getInt(st);
        int m = getInt(st);
        Maze maze = new Maze(n, m);

        String str;
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < m; j++) {
                maze.setInit(i, j, Character.getNumericValue(str.charAt(j)));
            }
        }

        maze.findDestination();
        maze.printCount();
    }

    static int getInt(StringTokenizer st) {
        return parseInt(st.nextToken());
    }
}

class Maze {

    static int[] D_X = {1, 0, -1, 0};
    static int[] D_Y = {0, 1, 0, -1};
    Room[][] rooms;

    class Room {
        int x;
        int y;
        int step;
        int num;
        boolean visited;

        Room (int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    Maze(int n, int m) {
        rooms = new Room[n][m];
    }

    void setInit(int x, int y, int num) {
        rooms[x][y] = new Room(x, y, num);
    }

    void findDestination() {
        Queue<Room> queue = new ArrayDeque<>();
        rooms[0][0].visited = true;
        rooms[0][0].step = 1;
        queue.add(rooms[0][0]);
        bfs(queue);
    }

    void bfs(Queue<Room> queue) {

        while (!queue.isEmpty()) {
            Room room = queue.poll();

            if ((room.x == rooms.length - 1) && (room.y == rooms[0].length - 1)) {
                break;
            }

            for (int k = 0; k < 4; k++) {
                int newX = D_X[k] + room.x;
                int newY = D_Y[k] + room.y;
                if (validRange(newX, newY)) {
                    rooms[newX][newY].visited = true;
                    rooms[newX][newY].step = room.step + 1;
                    queue.add(rooms[newX][newY]);
                }
            }
        }
    }

    void printCount() {
        System.out.println(rooms[rooms.length - 1][rooms[0].length - 1].step);
    }


    boolean validRange(int x, int y) {
        return x >= 0 && y >= 0 && x < rooms.length && y < rooms[0].length &&
                !rooms[x][y].visited && rooms[x][y].num == 1;
    }
}


