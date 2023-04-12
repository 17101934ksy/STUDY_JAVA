package dday3.boj_1450;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = getInt(st);
        int c = getInt(st);

        Knapsack knapsack = new Knapsack(n, c);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            knapsack.addItem(i, getInt(st));
        }

        knapsack.find();
    }

    private static int getInt(StringTokenizer st) {
        return parseInt(st.nextToken());
    }
}

class Knapsack {
    int[] items;
    int c;

    Knapsack(int n, int c) {
        items = new int[n];
        this.c = c;
    }

    void addItem(int i, int w) {
        items[i] = w;
    }

    void find() {
        int n = items.length;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        dfs(0, n / 2, 0, left);
        dfs(n / 2 + 1, n - 1, 0, right);

        left.sort(Comparator.comparingInt(k -> k));
        right.sort(Comparator.comparingInt(k -> k));

        int result = 0;
        int e = right.size() - 1;
        for (int i = 0; i < left.size(); i++) {
            while(e >= 0 && left.get(i) + right.get(e) > c) {
                e--;
            }
            result += e + 1;
        }
        System.out.println(result);
    }

    void dfs(int start, int end, int sum, List<Integer> list) {
        if (sum > c) return;
        if (start > end) {
            list.add(sum);
            return ;
        }

        dfs(start + 1, end, sum, list);
        dfs(start + 1, end, sum + items[start], list);
    }

}