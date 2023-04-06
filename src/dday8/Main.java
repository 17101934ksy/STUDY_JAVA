package dday8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = parseInt(st.nextToken()); // n개의 노드
        int m = parseInt(st.nextToken()); // m개의 간선
        int v = parseInt(st.nextToken()); // v번 노드 시작

        Graph graph = new Graph(n); // 그래프 생성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()); // 간선 입력
            graph.addEdge(parseInt(st.nextToken()), parseInt(st.nextToken()));
        }

        graph.sortNodeAdjacent();
        graph.dfs(v);
        graph.bfs(v);

        List<Integer> nodeDfs = graph.listDfs;
        List<Integer> nodeBfs = graph.listBfs;

        StringBuilder sb = new StringBuilder();
        for (Integer nu : nodeDfs) {
            sb.append(nu).append(" ");
        }
        System.out.println(sb);

        sb = new StringBuilder();
        for (Integer nu : nodeBfs) {
            sb.append(nu).append(" ");
        }
        System.out.println(sb);

    }
}

class Graph {
    Node[] nodes;
    List<Integer> listDfs = new ArrayList<>();
    List<Integer> listBfs = new ArrayList<>();

    class Node {
        int u;
        boolean visitedDfs;
        boolean visitedBfs;
        List<Node> adjacent = new ArrayList<>();

        Node(int u) {
            this.u = u;
        }
    }

    Graph(int n) {
        nodes = new Node[n + 1];
        for (int i = 0; i <= n; i++) nodes[i] = new Node(i);
    }

    void addEdge(int u, int v) {
        Node n1 = nodes[u];
        Node n2 = nodes[v];

        n1.adjacent.add(n2);
        n2.adjacent.add(n1);
    }

    void dfs(int idx) {
        Node root = nodes[idx]; // root node 가져오기
        root.visitedDfs = true; // 방문 처리
        listDfs.add(root.u); // 방문한 것 출력을 위해 배열에 추가
        for (Node n : root.adjacent) {
            if (!n.visitedDfs) {
                n.visitedDfs = true;
                dfs(n.u);
            }
        }
    }

    void bfs(int idx) {
        Node root = nodes[idx];
        Queue<Node> queue = new ArrayDeque<>(); // queue 호출
        root.visitedBfs = true; // root 방문 처리
        queue.add(root); //root 추가

        while(!queue.isEmpty()) {
            Node r = queue.poll();
            for (Node n : r.adjacent) {
                if (!n.visitedBfs) {
                    n.visitedBfs = true;
                    queue.add(n);
                }
            }
            listBfs.add(r.u);
        }
    }

    void sortNodeAdjacent() {
        for (int i = 1; i < nodes.length; i++) {
            nodes[i].adjacent.sort(Comparator.comparingInt((Node n) -> n.u));
        }
    }
}