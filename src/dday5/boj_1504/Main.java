package dday5.boj_1504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

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
        for (int i = 0; i < 2; i++) graph.addNeededNodes(i, getInt(st));

        System.out.println(graph.findShortDistance());
    }

    private static int getInt(StringTokenizer st) {
        return parseInt(st.nextToken());
    }
}

class Graph {

    static final int MAX_COST = 20_000_000;

    Node[] nodes;
    Node[] neededNodes;
    int[] costs;

    class Node {
        int u;
        boolean visited;
        List<Edge> edges = new ArrayList<>();

        Node (int u) {
            this.u = u;
        }
    }

    class Edge {
        int u;
        int v;
        int w;
        Edge oppositeEdge;

        Edge (int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

    }

    Graph(int n) {
        nodes = new Node[n + 1];
        costs = new int[n + 1];
        neededNodes = new Node[2];

        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node(i);
            costs[i] = MAX_COST;
        }

    }

    void addEdge(int u, int v, int w) {
        Node n1 = nodes[u];
        Node n2 = nodes[v];
        Edge e1 = new Edge(u, v, w);
        Edge e2 = new Edge(v, u, w);

        n1.edges.add(e1);
        n2.edges.add(e2);
        e1.oppositeEdge = e2;
        e2.oppositeEdge = e1;
    }

    void addNeededNodes(int i, int u) {
        neededNodes[i] = nodes[u];
    }

    int findShortDistance() {
        Node sn = nodes[1];
        Node n1 = neededNodes[0];
        Node n2 = neededNodes[1];
        Node fn = nodes[nodes.length - 1];

        int res1 = 0;
        res1 += dijkstra(sn, n1);
        res1 += dijkstra(n1, n2);
        res1 += dijkstra(n2, fn);

        int res2 = 0;
        res2 += dijkstra(sn, n2);
        res2 += dijkstra(n2, n1);
        res2 += dijkstra(n1, fn);

        if (res1 > MAX_COST && res2 > MAX_COST) return -1;
        return Math.min(res1, res2);
    }

    int dijkstra(Node sn, Node fn) {
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt((Edge e) -> e.w));
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].visited = false;
            costs[i] = MAX_COST;
        }

        costs[sn.u] = 0;
        queue.add(sn.edges.get(0));

        while(!queue.isEmpty()) {
            Edge e1 = queue.poll();
            Node n1 = nodes[e1.u];

            if (n1.visited) continue;
            n1.visited = true;

            for (Edge e : n1.edges) {
                if (costs[e.v] > costs[e.u] + e.w) {
                    costs[e.v] = costs[e.u] + e.w;
                    queue.add(e.oppositeEdge);
                }
            }
        }
        return costs[fn.u];
    }
    // 8 + 16 + 18  = 42
}
