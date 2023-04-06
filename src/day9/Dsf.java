package day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Dsf {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = parseInt(st.nextToken()); // 정점의 수
        int m = parseInt(st.nextToken()); // 간선의 수
        int r = parseInt(st.nextToken()); // 시작 정점

        Graph graph = new Graph(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph.addEdge(parseInt(st.nextToken()), parseInt(st.nextToken()));
        }

        graph.sortGraph();
        graph.dfs(r);
        graph.visitResult();
    }
}

class Graph {

    static int count;

    class Node {
        int u;
        int rank;
        PriorityQueue<Node> adjacent;
        boolean visited;

        Node(int u) {
            this.u = u;
            adjacent = new PriorityQueue<>(Comparator.comparingInt((Node n) -> n.u).reversed());
        }
    }

    Node[] nodes;
    Graph(int size) {
        nodes = new Node[size + 1];
        for (int i = 0; i <= size; i++) {
            nodes[i] = new Node(i);
        }
    }

    // 노드 더하기
    void addEdge(int u, int v) {
        Node n1 = nodes[u];
        Node n2 = nodes[v];

        n1.adjacent.add(n2);
        n2.adjacent.add(n1);
    }

    void dfs(int idx) {
        Node root = nodes[idx];
        root.visited = true;
        root.rank = ++count;
        for (Node n : root.adjacent) {
            if (!n.visited) {
                dfs(n.u);
            }
        }
    }

    void sortGraph() {
        Arrays.sort(nodes, Comparator.comparingInt((Node n) -> n.u).reversed());
    }

    void visitResult() {
        for (int i = 1; i < nodes.length; i++) {
            System.out.println(nodes[i].rank);
        }
    }
}

