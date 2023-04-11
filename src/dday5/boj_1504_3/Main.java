package dday5.boj_1504_3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = getInt(st);
        int m = getInt(st);

        Graph graph = new Graph(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph.addEdge(getInt(st), getInt(st), getInt(st));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = getInt(st);
        int v2 = getInt(st);

        System.out.println(graph.findShortDistance(v1, v2));
    }

    private static int getInt(StringTokenizer st) {
        return parseInt(st.nextToken());
    }
}

class Graph {

    static final int INF = 200_000_000;
    boolean[] visited;
    int[] costs;
    ArrayList<Node>[] adjacent;

    class Node {
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    Graph(int n) {
        visited = new boolean[n + 1];
        costs = new int[n + 1];
        adjacent = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adjacent[i] = new ArrayList<>();
    }

    void addEdge(int u, int v, int w) {
        adjacent[u].add(new Node(v, w));
        adjacent[v].add(new Node(u, w));
    }

    int findShortDistance(int v1, int v2) {

        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, costs.length - 1);

        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, costs.length - 1);

        if(res1 >= INF && res2 >= INF) return -1;
        return Math.min(res1, res2);
    }


    int dijkstra(int start, int end){
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt((Node n) -> n.w));
        Arrays.fill(visited, false);
        Arrays.fill(costs, INF);

        costs[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node n1 = queue.poll();

            if (visited[n1.v]) continue;
            visited[n1.v] = true;

            for (Node n2 : adjacent[n1.v]) {
                if (costs[n2.v] > n2.w + n1.w) {
                    costs[n2.v] = n2.w + n1.w;
                    queue.add(new Node(n2.v, costs[n2.v]));
                }
            }
        }
        return costs[end];
    }
}

