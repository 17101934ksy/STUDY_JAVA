package day9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

public class Boj2629 {
    
    static int n;
    static int[] w;
    static boolean[][] isPossible;
    static final int MAX_WEIGHT = 15000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = parseInt(br.readLine());
        w = new int[n];
        isPossible = new boolean[n + 1][MAX_WEIGHT + 1]; // MAX_WIEGHT 보다 큰 경우 무조건 "N"
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            w[i] = parseInt(st.nextToken());
        }
        
        dfs(0, 0);
        
        int m = parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int c = parseInt(st.nextToken());
            
            if (c > MAX_WEIGHT) sb.append("N ");
            else {
                if (isPossible[n][c]) sb.append("Y ");
                else sb.append("N ");
            }
        }
        
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    
    /*
    * dfs
    * isPossible이 메서드를 호출된 것만으로 true가 되는 이유는
    * 미리 dfs로 추 무게 검증 가능한 경우를 체크하는 용도이기 때문,
    * 만약 cnt = 10, w = 90 인 값이 해당 메서드를 안거치는 경우 추로 만들 수 없는 무게라는 의미
    * cnt = 1 ~ n개의 추를 순회하기위한 인덱스
    * wh = 추의 무게
    */
    private static void dfs(int cnt, int wh) {
        if (isPossible[cnt][wh]) return;
        isPossible[cnt][wh] = true; // 이 무게는 가능하다는 의미
        if (cnt == n) return;

        dfs(cnt + 1, wh + w[cnt]); // 이 경우는 추를 하나씩 놓는 경우로 n 번째 계속 반복되면 모든 추를 다올림
        dfs(cnt + 1, wh); // 순회할 때 까지 동일한 추 무게로 가져감 wh = 3이라면 n일 때도 계속 고정
        dfs(cnt + 1, abs(w[cnt] - wh)); // 반대쪽에 추를 놓음
    }
}