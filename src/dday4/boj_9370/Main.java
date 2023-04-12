package dday4.boj_9370;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            int n = getInt(st); // 교차로
            int m = getInt(st); // 도로 개수
            int t = getInt(st); // 목적지 후보

            st = new StringTokenizer(br.readLine());
            int s = getInt(st); // 출발 노드
            int g = getInt(st); // 점선 시작 노드
            int h = getInt(st); // 점선 끝 노드

            Graph graph = new Graph(n);
            graph.addDotted(g, h);

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                graph.addEdge(getInt(st), getInt(st), getInt(st));
            }
            for (int j = 0; j < t; j++) graph.addCandidate(parseInt(br.readLine()));

            for (int node : graph.findRoad(s)) {
                sb.append(node).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static int getInt(StringTokenizer st) {
        return parseInt(st.nextToken());
    }
}

class Graph {

    static final int MAX_LIMIT = 100_000_000;
    boolean[] visited;
    int[] costs;
    List<Node>[] adjacent;
    List<Integer> candidate = new ArrayList<>();
    int[] dotted = new int[2];

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

    void addCandidate(int n) {
        candidate.add(n);
    }

    void addDotted(int n1, int n2) {
        dotted[0] = n1;
        dotted[1] = n2;
    }

    List<Integer> findRoad(int s) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < candidate.size(); i++) {
            int res1 = dijkstra(s, candidate.get(i));

            int res2 = 0;
            res2 += dijkstra(s, dotted[0]);
            res2 += dijkstra(dotted[0], dotted[1]);
            res2 += dijkstra(dotted[1], candidate.get(i));

            if (res2 <= res1) {
                result.add(candidate.get(i));
                continue;
            }

            int res3 = 0;
            res3 += dijkstra(s, dotted[1]);
            res3 += dijkstra(dotted[1], dotted[0]);
            res3 += dijkstra(dotted[0], candidate.get(i));

            if (res3 <= res1) {
                result.add(candidate.get(i));
            }
        }
        result.sort(Comparator.comparingInt(n -> n));
        return result;
    }

    int dijkstra(int n1, int n2) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt((Node n) -> n.w));
        Arrays.fill(visited, false);
        Arrays.fill(costs, MAX_LIMIT);

        queue.add(new Node(n1, 0));
        costs[n1] = 0;

        while(!queue.isEmpty()) {
            Node sn = queue.poll();

            if (visited[sn.v]) continue;

            visited[sn.v] = true;

            for (Node fn : adjacent[sn.v]) {
                if (costs[fn.v] > costs[sn.v] + fn.w) {
                    costs[fn.v] = costs[sn.v] + fn.w;
                    queue.add(fn);
                }
            }
        }
        return costs[n2];
    }
}


///    6
// 1 ----- 2
//         | 2 *
//         3
//      4 / \ 3
//       4   5