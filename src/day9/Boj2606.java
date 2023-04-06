package day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Boj2606 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = parseInt(br.readLine()); // 컴퓨터 개수
        int e = parseInt(br.readLine()); // 간선 개수

        Boj2606Graph graph = new Boj2606Graph(n); // n개의 컴퓨터 노드 생성
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            graph.addEdge(parseInt(st.nextToken()), parseInt(st.nextToken())); // 간선 추가
        }

        graph.dfs(1);
        graph.printCnt();
    }


}

class Boj2606Graph {

    static int cnt;
    Node[] nodes;

    class Node {
        int u;
        boolean visited;
        List<Node> adjacent = new ArrayList<>();

        Node(int u) {
            this.u = u;
        }
    }

    Boj2606Graph(int n) {
        nodes = new Node[n + 1];
        for (int i = 0; i <= n; i++) nodes[i] = new Node(i);
    }

    void addEdge(int u, int v) {
        Node n1 = nodes[u];
        Node n2 = nodes[v];

        n1.adjacent.add(n2);
        n2.adjacent.add(n1);
    }

    void dfs(int r) {
        Node root = nodes[r];
        root.visited = true;
        for (Node n: root.adjacent) {
            if (!n.visited) {
                ++cnt;
                dfs(n.u);
            }
        }
    }

    void printCnt() {
        System.out.println(this.cnt);
    }

}