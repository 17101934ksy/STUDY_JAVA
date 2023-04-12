package dday4.boj_9370_2;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = getInt(st);
            int m = getInt(st);
            int t = getInt(st);

            Graph graph = new Graph(n);

            st = new StringTokenizer(br.readLine());
            int s = getInt(st);
            int g = getInt(st);
            int h = getInt(st);

            graph.addDotted(g, h);

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                graph.addEdge(getInt(st), getInt(st), getInt(st));
            }

            for (int k = 0; k < t; k++) graph.addCandidate(parseInt(br.readLine()));

            graph.findAndPrint(s);
        }
    }

    private static int getInt(StringTokenizer st) {
        return parseInt(st.nextToken());
    }
}

class Graph {

    static final int INF = 100_00_000;

    boolean[] visited;
    int[] dist;
    int[] dotted;
    List<Node>[] nodes;
    List<Integer> candidate = new ArrayList<>();

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
        dist = new int[n + 1];
        dotted = new int[2];
        nodes = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) nodes[i] = new ArrayList<>();
    }

    void addDotted(int g, int h) {
        dotted[0] = g;
        dotted[1] = h;
    }

    void addEdge(int u, int v, int w) {
        if ((dotted[0] == u && dotted[1] == v) ||
                (dotted[0] == v && dotted[1] == u)) {
            nodes[u].add(new Node(v, w * 2 - 1));
            nodes[v].add(new Node(u, w * 2 - 1));
        }

        else {
            nodes[u].add(new Node(v, w * 2));
            nodes[v].add(new Node(u, w * 2));
        }
    }

    void addCandidate(int c) {
        candidate.add(c);
    }

    void findAndPrint(int s) {
        StringBuilder sb = new StringBuilder();

        candidate.sort(Comparator.comparingInt(n -> n));

        dijkstra(s);
        for (int n : candidate) {
            if (dist[n] % 2 == 1) sb.append(n).append(" ");
        }

        System.out.println(sb);
    }


    void dijkstra(int s) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt((Node n) -> n.w));

        dist[s] = 0;
        queue.add(new Node(s, 0));

        while(!queue.isEmpty()) {
            Node n1 = queue.poll();

            if (visited[n1.v]) continue;
            visited[n1.v] = true;

            for (Node n2 : nodes[n1.v]) {
                if (!visited[n2.v] && dist[n2.v] > dist[n1.v] + n2.w) {
                    dist[n2.v] = dist[n1.v] + n2.w;
                    queue.add(new Node(n2.v, dist[n2.v]));
                }
            }
        }
    }
}