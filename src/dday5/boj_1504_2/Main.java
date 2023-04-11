package dday5.boj_1504_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N, E, Ans; // N:정점, E:간선
    private static int INF = 200000000; //200,000 * 1,000
    private static ArrayList<Node>[] adjList;
    private static int[] cost;
    private static boolean[] visited;
    private static class Node implements Comparable<Node>{
        int dest, cost; //dest: 목적지, cost: 거리
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost; //cost 기준 오름차순 정렬
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Ans = 0;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        cost = new int[N+1];
        visited = new boolean[N+1];

        //인접리스트 초기화
        for (int i = 0; i < N+1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //출발지
            int b = Integer.parseInt(st.nextToken()); //도착지
            int c = Integer.parseInt(st.nextToken()); //비용(거리)
            adjList[a].add(new Node(b, c));//단방향인 경우 이것만 해도 됨
            adjList[b].add(new Node(a, c));//무방향(양방향)은 이것도 해야 함
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ans1 = 0; // 1 > v1 > v2 > N
        ans1 += dijkstra(1, v1);
        ans1 += dijkstra(v1, v2);
        ans1 += dijkstra(v2, N);

        int ans2 = 0; // 1 > v2 > v1 > N
        ans2 += dijkstra(1, v2);
        ans2 += dijkstra(v2, v1);
        ans2 += dijkstra(v1, N);

        if(ans1 >= INF && ans2 >= INF) Ans = -1; //경로가 없는 경우
        else Ans = Math.min(ans1, ans2); //경로가 있을 경우 더 작은 값

        bw.write(Ans+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
    private static int dijkstra(int start, int end){
        //최저비용 기준 탐색경로 저장 위한 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(visited, false); //방문여부 체크 배열 false로 초기화
        Arrays.fill(cost, INF); //cost 배열 INF로 초기화

        cost[start] = 0; //시작점이기 때문에 거리 0으로 셋팅
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()){
            Node now = pq.poll();

            if(visited[now.dest]) continue; //방문했던 정점이면 스킵
            visited[now.dest] = true; //미방문이면 방문으로(true)로 셋팅하고 for문 처리

            //간선 탐색
            for (Node next:adjList[now.dest]) {
                if(cost[next.dest] > next.cost + now.cost){
                    cost[next.dest] = next.cost + now.cost;
                    pq.add(new Node(next.dest, cost[next.dest]));
                }
            }
        }

        return cost[end]; //목적지 end 까지의 최단거리
    }
}