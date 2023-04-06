package day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

import static java.lang.Integer.parseInt;

public class Dsf {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = parseInt(st.nextToken()); // 정점의 수
        int m = parseInt(st.nextToken()); // 간선의 수
        int r = parseInt(st.nextToken()); // 시작 정점

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

        }

    }
}

class Graph {

    private static final int MAX_NODES = 100000;

    class Node {
        int u;
        PriorityQueue<Node> adjacent;
        boolean visited;

        Node(int u) {
            this.u = u;
            adjacent = new PriorityQueue<>();
        }
    }

    Node[] nodes;
    Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < MAX_NODES; i++) {
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

    // Node의 순서를 u, v 순서로 정렬
    void sortNodes() {
        Arrays.sort(nodes, Comparator.comparingInt((Node n) -> n.u));
    }

    void dfs(int idx) {
        Node root = nodes[idx];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.visited = true;
        while(!stack.isEmpty()) {
            Node r = stack.pop();
            for (Node n : r.adjacent) {
                if (n.visited == false) {
                    n.visited = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }

    void visit(Node n) {
        System.out.println(n.u);
    }
}