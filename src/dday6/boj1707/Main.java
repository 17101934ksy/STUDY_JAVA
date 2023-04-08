package dday6.boj1707;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int k = parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int n = getInt(st);
            int m = getInt(st);

            Graph graph = new Graph(n);
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                graph.addEdge(getInt(st), getInt(st));
            }
            sb.append(graph.isBipartiteGraph() ? "YES" : "NO").append('\n');
        }

        System.out.println(sb);

    }

    static int getInt(StringTokenizer st) {
        return parseInt(st.nextToken());
    }
}

class Graph {

    Node[] nodes;

    class Node {
        int u;
        boolean visited;
        Boolean bipartite;
        List<Node> adjacent = new ArrayList<>();

        Node(int u) {
            this.u = u;
        }
    }

    Graph (int n) {
        nodes = new Node[n + 1];
        for (int i = 0; i <= n; i++) nodes[i] = new Node(i);
    }

    void addEdge(int u, int v) {
        nodes[u].adjacent.add(nodes[v]);
        nodes[v].adjacent.add(nodes[u]);
    }

    boolean isBipartiteGraph() {
        Queue<Node> queue = new ArrayDeque<>();

        for (int i = 1; i < nodes.length; i++) {
            if(nodes[i].visited) continue;
            nodes[i].visited = true;
            queue.add(nodes[i]);
            if (!bfs(queue)) return false;
        }
        return true;
    }

    boolean bfs(Queue<Node> queue) {
        while(!queue.isEmpty()) {
            Node n1 = queue.poll();

            for (Node n2 : n1.adjacent) {

                if (n2.visited) {
                    if (n1.bipartite == n2.bipartite) return false;
                }
                else {
                    if (n1.bipartite == null && n2.bipartite == null) {
                        n1.bipartite = false;
                        n2.bipartite = true;
                    }
                    else if (n1.bipartite != null && n2.bipartite == null) {
                        n2.bipartite = !n1.bipartite;
                    }
                    else if (n1.bipartite == null) {
                        n1.bipartite = !n2.bipartite;
                    }
                    else {
                        if (n1.bipartite == n2.bipartite) return false;
                    }
                    n2.visited = true;
                    queue.add(n2);
                }
            }
        }
        return true;
    }
}

// 1 - 2
// 3 - 4
//  \  |
//   \ 5