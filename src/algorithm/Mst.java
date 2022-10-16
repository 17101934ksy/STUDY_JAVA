package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;


class Edge implements Comparable<Edge>{

    int x, y, weight;

   Edge(int x, int y, int weight){
       this.x = x;
       this.y = y;
       this.weight = weight;
   }

    @Override
    public int compareTo(Edge o) {
        return weight - o.weight;
    }
}


public class Mst {

    static StringTokenizer st;
    static int v, e;

    static int[] parent;
    static PriorityQueue<Edge> queue;

    static int totalWeight;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(bufferedReader.readLine());

        v = parseInt(st.nextToken());
        e = parseInt(st.nextToken());

        queue = new PriorityQueue<>(e);
        parent = new int[v + 1];

        for(int i = 1; i <= v; i++){
            parent[i] = i;
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(bufferedReader.readLine());
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());
            int weight = parseInt(st.nextToken());

            queue.offer(new Edge(x, y, weight));
        }

        while(!queue.isEmpty()) {
            Edge edge = queue.poll();

            //z의 연결리스트 노드가 z -> y -> x 루트: x
            //x의 연결리스트 노드가 x -> x 루트: x
            if(find(edge.x) != find(edge.y)){
                union(edge.x, edge.y);
                totalWeight += edge.weight;
            }
        }
        System.out.print(totalWeight);
    }

    /**
     * 루트가 다른 노드를 합치는 연산
     * if a의 루트 노드 < b의 루트노드
     * @return b의 루트노드가 루트로 합병된 트리구조
     */
    public static void union(int a, int b){
        int p1 = find(a);
        int p2 = find(b);

        if (p1 < p2)
            parent[p2] = p1;
        else
            parent[p1] = p2;
    }

    /**
     * 루트 노드를 찾는 메소드
     * 재귀 호출로 루트노드를 찾음
     * if a == root: return root;
     * else: parent[a] = find(parent[a]) -> if 루트 == b:
     * parent[a] = b
     * @return 루트노드의 값
     */
    public static int find(int a){
        if (parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }

}
