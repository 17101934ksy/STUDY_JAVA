package dday7.boj16928_2;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, res;
	static int start=1, end=100;
	static boolean[] visited;
	static Map<Integer, Integer> gameThings;		//뱀과 사다리 -> x,y
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[101];		//1~100
		gameThings = new HashMap<>();
		
		for(int i=0; i<N; i++) {		//사다리
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			gameThings.put(x, y);
		}
		
		for(int i=0; i<M; i++) {	//뱀
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			gameThings.put(x, y);
		}
		
		bfs();
		bw.write(res + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			res++;
			for(int i=0,qSize=q.size(); i<qSize; i++) {
				int now = q.poll();
				
				for(int j=1; j<=6; j++) {		//주사위값 계산
					int move = now + j;
					if(move==end) return;
					
					if(move > end) continue;
					if(visited[move]) continue;
					
					visited[move] = true;
					if(gameThings.containsKey(move)) {		//뱀, 사다리를 만남
						move = gameThings.get(move);
					}
					q.add(move);
				}
			}
		}//end of while
	}
}