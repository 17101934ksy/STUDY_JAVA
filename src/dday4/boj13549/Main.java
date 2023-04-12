package dday4.boj13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());

        Graph graph = new Graph();
        System.out.println(graph.findSister(n, m));
    }
}

class Graph {

    static final int MAX_LIMIT = 100_000;

    boolean[] visited = new boolean[MAX_LIMIT + 1];

    class Node {
        int x; // 도착 위치
        int t; // 이동 시간

        Node(int x, int t) {
            this.x = x;
            this.t = t;
        }
    }

    Graph() {}

    int findSister(int start, int end) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, 0));
        visited[start] = true;

        int result = MAX_LIMIT;
        while(!queue.isEmpty()) {
            Node n1 = queue.poll();

            if (n1.x == end) {
                result = Math.min(result, n1.t);
            }

            if (n1.x * 2 <= MAX_LIMIT && !visited[n1.x * 2]) {
                queue.offer(new Node(n1.x * 2, n1.t));
                visited[n1.x * 2] = true;
            }

            if (n1.x - 1 >= 0 && !visited[n1.x - 1]) {
                queue.offer(new Node(n1.x - 1, n1.t + 1));
                visited[n1.x - 1] = true;
            }


            if (n1.x + 1 <= MAX_LIMIT && !visited[n1.x + 1]) {
                queue.offer(new Node(n1.x + 1, n1.t + 1));
                visited[n1.x + 1] = true;
            }

        }

        return result;
    }
}