package dday8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Boj1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = parseInt(br.readLine());
        int[] result = new int[t];
        int m, n, k;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = getInt(st);
            n = getInt(st);
            k = getInt(st);
            Field field = new Field(m, n);

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                field.cabbages[getInt(st)][getInt(st)] = field.setCabbage();
            }
            field.calculateWhiteBug(m, n);
            result[i] = field.counts.size();
        }

        for (int r : result) {
            System.out.println(r);
        }
    }

    static int getInt(StringTokenizer st) {
        return parseInt(st.nextToken());
    }
}

class Field {

    static final int[] D_X = {1, 0, -1, 0};
    static final int[] D_Y = {0, 1, 0, -1};

    Cabbage[][] cabbages;
    List<Integer> counts = new ArrayList<>();

    class Cabbage {
        int num;
        boolean visited;

        Cabbage(int num) {
            this.num = num;
        }
    }

    Field(int m, int n) {
        cabbages = new Cabbage[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cabbages[i][j] = new Cabbage(0);
            }
        }
    }

    Cabbage setCabbage() {
        return new Cabbage(1);
    }


    void calculateWhiteBug(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (validRange(i, j) && !cabbages[i][j].visited && cabbages[i][j].num == 1) {
                    dfs(i, j);
                    counts.add(1);
                }
            }
        }
    }

    void dfs(int x, int y) {
        if (!cabbages[x][y].visited && cabbages[x][y].num == 1) {
            cabbages[x][y].visited = true;
            for (int i = 0; i < 4; i++) {
                int newX = D_X[i] + x;
                int newY = D_Y[i] + y;
                if (validRange(newX, newY)) dfs(newX, newY);
            }
        }
    }

    boolean validRange(int x, int y) {
        return x >= 0 && y >= 0 && x < cabbages.length && y < cabbages[0].length;
    }
}