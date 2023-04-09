package dday6.boj1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = getInt(st);
        int e = getInt(st);

        int startNode = parseInt(br.readLine());

        Graph graph = new Graph(v);
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            graph.addEdge(getInt(st), getInt(st), getInt(st));
        }

        System.out.print(graph.findShortPath(startNode));
    }

    static int getInt(StringTokenizer st) {
        return parseInt(st.nextToken());
    }
}

class Graph {

    Node[] nodes;

    class Node {
        int u;
        int distance = -1;
        List<Edge> adjacent = new ArrayList<>();

        Node(int u) {
            this.u = u;
        }
    }

    class Edge {
        int v; // 도착
        int w; // 가중치
        boolean visited;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    Graph(int n) {
        nodes = new Node[n + 1];
        for (int i = 0; i <= n; i++) nodes[i] = new Node(i);
    }

    // 단방향 간선
    void addEdge(int u, int v, int w) {
        nodes[u].adjacent.add(new Edge(v, w));
    }

    void sortEdge() {
        for (int i = 1; i < nodes.length; i++) {
            nodes[i].adjacent.sort(Comparator.comparingInt((Edge e) -> e.w));
        }
    }

    String findShortPath(int sn) {
        StringBuilder sb = new StringBuilder(); // 출력을 위한 builder
        Queue<Node> queue = new ArrayDeque<>(); // queue 생성

        sortEdge(); // 정렬

        nodes[sn].distance = 0; // 거리 0
        queue.add(nodes[sn]); // queue 입력

        while(!queue.isEmpty()) {
            Node n1 = queue.poll(); // queue 에서 꺼내기

            for (Edge e : n1.adjacent) {
                if (!e.visited) { // 방문 안했다면
                    e.visited = true; // 방문 표시
                    Node n2 = nodes[e.v]; // 간선의 v (도착지)로 노드 찾기

                    if (n2.distance == -1) n2.distance = n1.distance + e.w; // 부모 노드에 엣지의 가중치 더하기
                    else {
                        int d = n2.distance;
                        n2.distance = Math.min(n2.distance, n1.distance + e.w);

                        if (d == n2.distance) continue;
                    }
                    queue.add(n2); // 노드를 큐에 넣어서 bfs
                }
            }
        }

        for (int i = 1; i < nodes.length; i++) {
            sb.append(nodes[i].distance != -1 ? nodes[i].distance : "INF").append("\n");
        }
        return sb.toString();
    }
}